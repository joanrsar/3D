/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.penaltykick.presentacion;

import com.co.penaltykick.modelo.Balon;
import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.util.TangentBinormalGenerator;

/**
 *
 * @author joanrincon
 */
public class Campo  extends SimpleApplication  implements AnimEventListener {

    private TerrainQuad terreno;
    private Material    material;
    Balon   balon       = new Balon();
    
    private AnimChannel channel;
    private AnimControl control;
    Geometry    player;
    
    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(50);
        
        initKeys();
      //  cam.setLocation(Vector3f.UNIT_XYZ);
       // cam.setFrustum( 0, 150, 150, 150, 150, 150 );
        
        material = new Material(assetManager, 
            "Common/MatDefs/Terrain/Terrain.j3md");      
       
        Texture grass = assetManager.loadTexture(
            "Textures/grass2.jpg");
        grass.setWrap(Texture.WrapMode.Repeat);
        material.setTexture("Tex1", grass);
        material.setFloat("Tex1Scale", 64f);
        
        int patchSize = 65;
        terreno = new TerrainQuad("my terrain", patchSize, 513, null);
        
        terreno.setMaterial(material);
        terreno.setLocalTranslation(0, -100, 0);
        terreno.setLocalScale(2f, 1f, 2f);
        rootNode.attachChild(terreno);
 
        TerrainLodControl control = new TerrainLodControl(terreno, getCamera());
        terreno.addControl(control);
        
        /*Sphere sphereMesh = new Sphere(16, 16, 2f);
        Geometry sphereGeo = new Geometry("Shiny rock", sphereMesh);
        sphereMesh.setTextureMode(Sphere.TextureMode.Projected); // better quality on spheres
        TangentBinormalGenerator.generate(sphereMesh);  
        // for lighting effect
        Material sphereMat = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        sphereMat.setTexture("DiffuseMap",
                assetManager.loadTexture("Textures/balon.jpg"));
        
        sphereMat.setBoolean("UseMaterialColors", true);
        sphereMat.setColor("Diffuse", ColorRGBA.White);
        sphereMat.setColor("Specular", ColorRGBA.White);
        sphereMat.setFloat("Shininess", 64f);  // [0,128]
        sphereGeo.setMaterial(sphereMat);
        sphereGeo.setLocalTranslation(0, -3, 1); // Move it a bit
        sphereGeo.rotate(1.2f, 0, 0);          // Rotate it a bit
        
        rootNode.attachChild(sphereGeo);
        
        
        
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1, 0, -2).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);*/
        
        Box b = new Box(1, 1, 0);
        player = new Geometry("blue cube", b);
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        player.setMaterial(mat);
        rootNode.attachChild(player);

        
        /*control = player.getControl(AnimControl.class);
        control.addListener(this);
        channel = control.createChannel();
        channel.setAnim("stand");*/
        
    }
    


    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
    if (animName.equals("Hit")) {
      channel.setAnim("stand", 0.50f);
      channel.setLoopMode(LoopMode.DontLoop);
      channel.setSpeed(1f);
    }
  }
 
  public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
    // unused
  }
 
  /** Custom Keybinding: Map named actions to inputs. */
  private void initKeys() {
    inputManager.addMapping("Hit", new KeyTrigger(KeyInput.KEY_SPACE));
    inputManager.addListener(actionListener, "Hit");
  }
  
  private ActionListener actionListener = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {
      if (name.equals("Hit") && !keyPressed) {
        if (!channel.getAnimationName().equals("Hit")) {
          channel.setAnim("Hit", 0.50f);
          channel.setLoopMode(LoopMode.Loop);
        }
      }
    }
  };    
}
