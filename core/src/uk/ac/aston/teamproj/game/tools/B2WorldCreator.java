package uk.ac.aston.teamproj.game.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import uk.ac.aston.teamproj.game.MainGame;
import uk.ac.aston.teamproj.game.sprites.Bomb;
import uk.ac.aston.teamproj.game.sprites.Boundary;
import uk.ac.aston.teamproj.game.sprites.Brick;
import uk.ac.aston.teamproj.game.sprites.Coin;
import uk.ac.aston.teamproj.game.sprites.EndPlane;
import uk.ac.aston.teamproj.game.sprites.Lightning;
import uk.ac.aston.teamproj.game.sprites.Mud;

public class B2WorldCreator {
	
	
	public B2WorldCreator(World world, TiledMap map) {
		//change when classes individual objects - take logic in own classes of obj
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;
		
		// create ground bodies/fixtures
		for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth()/2)/MainGame.PPM, (rect.getY() + rect.getHeight()/2) / MainGame.PPM);
			
			body = world.createBody(bdef);
			
			// Rect starts at the center
			shape.setAsBox(rect.getWidth() / 2 / MainGame.PPM, rect.getHeight() / 2 / MainGame.PPM);
			fdef.shape = shape;
			body.createFixture(fdef);
		}
		
		// create brick bodies / fixtures 
		for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Brick(world, map, rect);
		}
		
		// create boxes
		for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Brick(world, map, rect);
		}
		
		// create bomb bodies/fixtures
		for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Bomb(world, map, rect);			
		}
		
		// create lightning power ups bodies/fixtures
		for (MapObject object : map.getLayers().get(8).getObjects().getByType(EllipseMapObject.class)) {
			//Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			//new Lightning(world, map, rect);		
			
			Ellipse circle = ((EllipseMapObject) object).getEllipse();;
			new Lightning(world, map, circle);
		}
		
		//create mud power downs bodies/fixtures
		for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Mud(world, map, rect);			
		}
		
		//define boundary
		for (MapObject object : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Boundary(world, map, rect);			
		}
		
		//create Coin bodies
		for (MapObject object : map.getLayers().get(6).getObjects().getByType(EllipseMapObject.class)) {
			//Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			//new Coin(world, map, rect);	
			
			Ellipse circle = ((EllipseMapObject) object).getEllipse();;
			
			new Coin(world, map, circle);
		}
		
		//create Plane bodies/fixtures
		for (MapObject object : map.getLayers().get(11).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new EndPlane(world, map, rect);			
		}
	}
}
