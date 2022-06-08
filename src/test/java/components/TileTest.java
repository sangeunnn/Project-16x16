package components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.Tileset;
import project_16x16.components.Tile;
import project_16x16.components.Tile.TileType;

public class TileTest {

    @Test
    public void TileConstructorTest() {
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertTrue(tile.notNull());
    }

    @Test
    public void getIDTest() {
        int id = 1;
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertEquals(id, tile.getID());
    }

    @Test
    public void getNameTest() {
        String name = "abc";
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertEquals(name, tile.getName());
    }

    @Test
    public void getTileTypeTest() {
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertEquals(TileType.BACKGROUND, tile.getTileType());
    }

    @Test
    public void getPositionTest() {
        int id = 1;
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertEquals(new PVector(Tileset.TILESETWIDTH / id, Tileset.TILESETWIDTH % id), tile.getPosition());
    }

    @Test
    public void notNullTrueTest() {
        Tile tile = new Tile(1, "abc", new PImage(), TileType.BACKGROUND);
        assertTrue(tile.notNull());
    }

    @Test
    public void notNullFalseTest() {
        Tile tile = new Tile(1, null, new PImage(), TileType.BACKGROUND);
        assertFalse(tile.notNull());
    }
}
