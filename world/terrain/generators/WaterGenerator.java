package world.terrain.generators;

import gui.Canvas;
import java.awt.Color;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import world.World;
import world.terrain.Generator;
import world.terrain.misc.PerlinNoise;

/**
* This is a basic Water Generator that generates "lakes" that are simply
* randomized rectangles set within specified dimensional constraints
* rivers are also generated, starting at random position within a lake and
* randomly meandering until the specified river length is reached
* @author Joseph Cherneske
*/
public class WaterGenerator extends Generator {
    
    public WaterGenerator(){
        super();
        this.setParameter("maskcurve", "0.1");
        this.setParameter("lakes", "1");
        this.setParameter("max", "10");
        this.setParameter("min", "1");
        this.setParameter("rlength", "100");
        this.setParameter("elevation", ".8");
        this.setParameter("lakeoctaves", "1");
        this.setParameter("rlength", "10");
        this.setParameter("riverThickness", "1");
        this.setParameter("riverchecklen", "1");
    }
    @Override
    /*
    * Copy/Paste this for sample generation: WaterGenerator:tile=6,lakes=32,max=40,min=10,rlength=100
    */
    public void generate(World w, int layer) {
        /*Parameters
         ==========*/
        
        /* lakes: the total number of lakes to generate, which also will be the
         * total number of rivers
         */
        int lakes = Integer.parseInt(getParameter("lakes"));
        
        //max, min: the minimum and maximum dimensional ranges of the rectangular lakes
        int max = Integer.parseInt(getParameter("max"));
        int min = Integer.parseInt(getParameter("min"));
        
        //rlength: the length of the rivers to be generated
        int rlength = Integer.parseInt(getParameter("rlength"));
        
        //lakeoctaves: number of octaves to use for lake perlin noise
        int lakeoctaves = Integer.parseInt(getParameter("lakeoctaves"));
        
        //riverchecklen: number of tiles to check/average in each direction when 
        //generating rivers
        int riverchecklen = Integer.parseInt(getParameter("riverchecklen"));
        
        //modifier for the lake mask
        float maskcurve = Float.parseFloat(getParameter("maskcurve"));
       
        //river thickness
        int riverThickness = Integer.parseInt(getParameter("riverThickness"));
        
         /*Variables
         ==========*/
         
        /* points is an ArrayList of integer Arrays used to store the starting
         * points for the generated lakes
         */
        ArrayList<int[]> points = new ArrayList<>();
        
        //Create a new random object rand and get set the seed from the World
        Random rand = new Random();
        rand.setSeed(getSeed());
        
        PerlinNoise perlin = new PerlinNoise();
        
        float[][] hmap = w.getElevationMap();
        
        //Now generate our random starting points for the lakes
        for(int i=0;i<lakes;i++){
            points.add(new int[]{rand.nextInt(w.columns()),rand.nextInt(w.rows())});
            System.out.println("Point " + i + " x=" + points.get(points.size()-1)[0] + " y=" + points.get(points.size()-1)[1]);
        }
        
        //Now draw rectangles on the world using the generated coordinates
        for(int[] x: points){
            /* set the width and height of the rectangles using a random number
             * from parameter min to max
             */
            int rwidth = min+rand.nextInt(max-min);
            int rheight = min+rand.nextInt(max-min);
            
            //New: use perlin noise algorithm to make the lakes look more realistic
            
            
            float[][] perlinmap = perlin.generatePerlinNoise(perlin.generateWhiteNoise(rwidth, rheight, getSeed()),lakeoctaves);
            //create a lake "mask", basically a rectangular gradient.
            float[][] lakemask = new float[rwidth][rheight];
             
            for(int i=0;i<rwidth;i++){
                for(int j=0;j<rheight;j++){
                    if(i<=j*rwidth/rheight&&i<=rwidth-j*rwidth/rheight){//top
                        lakemask[i][j]= ((float)i/rwidth*(float)Math.pow(2.,(double)maskcurve));
                    }else if(i<=j*rwidth/rheight&&i>rwidth-j*rwidth/rheight){//right
                        lakemask[i][j]=((float)(rheight-j)/rheight*(float)Math.pow(2.,(double)maskcurve));
                    }else if(i>j*rwidth/rheight&&i>rwidth-j*rwidth/rheight){//down
                        lakemask[i][j]= ((float)(rwidth-i)/rwidth*(float)Math.pow(2.,(double)maskcurve));
                    }else if(i>j*rwidth/rheight&&i<=rwidth-j*rwidth/rheight){//left
                        lakemask[i][j]=((float)j/rheight*(float)Math.pow(2.,(double)maskcurve));
                    }else{
                        lakemask[i][j]=0;
                    }
                }
            }
            
            
            //Now draw the rectangles on the World!
            for(int i=0; i<rheight; i++){
                for(int j=0; j<rwidth; j++){
                    if(x[0]+j>w.columns()-1||x[1]+i>w.rows()-1)continue;
                    //w.setTile(x[0]+j,x[1]+i, layer, true);
                    if (perlinmap[j][i]+lakemask[j][i] > Double.parseDouble(getParameter("elevation"))) w.setTile(x[0]+j, x[1]+i, layer, true);
                    
                }
            }
            
            int next[] = x;
            
            
            //river starting point in middle of lake
            next[0]+=rwidth/2;
            next[1]+=rheight/2;
            
            riverloop:
            for(int i=0; i<rlength;i++){
                
                
                //determine the next direction by adding the next few
                //tiles of heightmap, takes into account riverThickness
                float dsum[] = {0,0,0,0};
                
                for(int j=1;j<=riverchecklen+riverThickness;j++){
                    try{
                        dsum[0]+=hmap[next[0]][next[1]+j];
                        dsum[1]+=hmap[next[0]+j][next[1]];
                        dsum[2]+=hmap[next[0]][next[1]-j];
                        dsum[3]+=hmap[next[0]-j][next[1]];
                    }catch(ArrayIndexOutOfBoundsException e){
                        
                    }
                }
                
                int direction = 0; //default direction
                float lowest = (float)100.; //arbitrarily large number
                
                //find the lowest elevation direction that ALSO doesn't
                //intersect with another water tile OR runs off the world
                for(int j=0;j<4;j++){
                    if(dsum[j]<lowest){
                        switch(j){ //check for water tile, if yes, then next loop
                            case 0: if(w.getTile(next[0], next[1]+riverThickness, layer)!=-1 || next[1]+1>w.columns()-1)continue;
                            case 1: if(w.getTile(next[0]+riverThickness, next[1], layer)!=-1 || next[0]+1>w.rows()-1)continue;
                            case 2: if(w.getTile(next[0], next[1]-riverThickness, layer)!=-1 || next[1]-1<0)continue;
                            case 3: if(w.getTile(next[0]-riverThickness, next[1], layer)!=-1 || next[0]-1<0)continue;
                        }
                        lowest=dsum[j];
                        direction=j;
                    }
                }
                
                
                
                
                
                switch(direction){
                    case 0://north
                        next[1]+=1;
                        break;
                    case 1://east
                        next[0]+=1;
                        break;
                    case 2://south
                        next[1]-=1;
                        break;
                    case 3://west
                        next[0]-=1;
                }
                
                //draw the tiles, now with added river thickness!
                
                for(int j=0;j<riverThickness;j++){
                    try{
                        if(j==0){
                            w.setTile(next[0], next[1], layer, true);
                        }else{
                            for(int j2=0;j2<j;j2++){ //diamond pattern??
                                w.setTile(next[0]+j2, next[1], layer, true);
                                w.setTile(next[0]-j2, next[1], layer, true);
                                w.setTile(next[0], next[1]+j2, layer, true);
                                w.setTile(next[0], next[1]-j2, layer, true);
                            }
                        }
                        
                    }catch(java.lang.ArrayIndexOutOfBoundsException e){
                        System.out.println("Out of world bounds, continue generation");
                    }
                }
            }
                
                
                
        }
    }
}

