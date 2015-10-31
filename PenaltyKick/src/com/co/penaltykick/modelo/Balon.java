/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.penaltykick.modelo;

import com.co.penaltykick.presentacion.Campo;
import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.TangentBinormalGenerator;

/**
 *
 * @author joanrincon
 */
public class Balon {



    public void dibujar() {
      /*  Sphere sphereMesh = new Sphere(32, 32, 2f);
        Geometry sphereGeo = new Geometry("Shiny rock", sphereMesh);
        sphereMesh.setTextureMode(Sphere.TextureMode.Projected); // better quality on spheres
        TangentBinormalGenerator.generate(sphereMesh);           // for lighting effect
        Material sphereMat = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        sphereMat.setTexture("DiffuseMap",
                assetManager.loadTexture("Textures/balon.jpg"));
        sphereMat.setBoolean("UseMaterialColors", true);
        sphereMat.setColor("Diffuse", ColorRGBA.White);
        sphereMat.setColor("Specular", ColorRGBA.White);
        sphereMat.setFloat("Shininess", 64f);  // [0,128]
        sphereGeo.setMaterial(sphereMat);
        sphereGeo.setLocalTranslation(0, 2, -2); // Move it a bit
        sphereGeo.rotate(1.6f, 0, 0);          // Rotate it a bit
        rootNode.attachChild(sphereGeo);

        /**
         * Must add a light to make the lit object visible!
        
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1, 0, -2).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);*/
    }
}
