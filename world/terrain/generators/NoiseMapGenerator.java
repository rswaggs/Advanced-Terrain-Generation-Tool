package world.terrain.generators;

import gui.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import misc.MiscMath;
import world.World;
import world.terrain.Generator;
import world.terrain.misc.DiamondSquare;
import world.terrain.misc.Perlin;

/**
 * Creates patches of terrain using a noisemap generated by the DiamondSquare algorithm.
 * @author Jeremy
 * @see DiamondSquare
 */
public class NoiseMapGenerator extends Generator {

    public NoiseMapGenerator() {
        super();
        this.setParameter("elevation", "0");
        this.setParameter("algo", "Perlin");
    }
    
    @Override
    public void generate(World w, int layer) {
        
        float[][] map = World.getWorld().createHeightMap(getParameter("algo"), true);

        // Create terrain
        for (int i = 0; i < w.columns(); i++) {
            for (int j = 0; j < w.rows(); j++) {
                if (i >= map.length || j >= map.length) continue;
                if (map[i][j] < Double.parseDouble(getParameter("elevation"))) 
                    w.setTile(i, j, layer, true);
            }
        }
    }
    
}