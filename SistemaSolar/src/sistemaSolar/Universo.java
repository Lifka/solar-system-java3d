/*

    Gallardo Morales, Juan Carlos - jcgallardomorales@gmail.com
    Izquierdo Vera, Javier - javieriizquierdovera@gmail.com

 */
package sistemaSolar;

import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.ViewingPlatform;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TransformGroup;

public class Universo {
    private Nave nave;
    private HashMap<String,Astro> astros;
    private Texture textura;
    private Canvas3D aCanvas;
    

    public Universo (String archivo_text,Canvas3D aCanvas){
        this.textura = new TextureLoader(archivo_text, null).getTexture();
        this.nave = null;
        this.astros = new HashMap<String,Astro>();
        this.aCanvas = aCanvas;
    }
    
    public int getNumComponentes(){
        int total = astros.size();
        if (nave != null)
            total++;
        return total;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public HashMap<String,Astro> getAstros() {
        return astros;
    }

    public void setAstros(HashMap<String,Astro> astros) {
        this.astros = astros;
    }
    
    public void addAstro(Astro ast){
        astros.put(ast.getNombre(),ast);
    }
    
    public int numAstros(){
        return astros.size();
    }
    
    public void crearSistemaSolar(){
        String dir_text_sol = "texturas_estrellas/";
        String dir_text_sat = "texturas_satelites/";
        String dir_text_pla = "texturas_planetas/";
        
        // ESTRELLAS --> SOL
        Astro sol = new Estrella("sol", 696342, 0.0, dir_text_sol + "sol.jpg", new Material(), Color.white, 26, 10);
        astros.put(sol.getNombre(),sol);
        
        // SATÉLITES
        Astro luna = new Satelite("luna", 1737, 370300, dir_text_sat + "luna.jpg", new Material(),Color.white, 27.32, 27.32);
        astros.put(luna.getNombre(), luna);
        
        Astro fobos = new Satelite("fobos", 11, 9380, dir_text_sat + "fobos.jpg", new Material(), Color.white, 0.3 , 0.3);
        astros.put(fobos.getNombre(), fobos);
        
        Astro deimos = new Satelite("deimos",7,23460, dir_text_sat + "deimos.jpg", new Material(), Color.white, 1.25,1.25); 
        astros.put(deimos.getNombre(), deimos);
        
        Astro io = new Satelite("io",1820,422000, dir_text_sat + "io.jpg", new Material(), Color.white, 1.75,1.75);
        astros.put(io.getNombre(),io);
        
        Astro europa = new Satelite("europa",1561, 671000, dir_text_sat + "europa.jpg", new Material(), Color.white, 3.54,3.54);
        astros.put(europa.getNombre(), europa);
        
        Astro calisto = new Satelite("calisto",2410, 1880000, dir_text_sat + "calisto.jpg", new Material(), Color.white, 16.7, 16.7);
        astros.put(calisto.getNombre(), calisto);
        
        Astro titania = new Satelite("titania",788, 436000, dir_text_sat + "titania.jpg", new Material(), Color.white, 8.7, 8.7);
        astros.put(titania.getNombre(), titania);
        
        Astro ariel = new Satelite("ariel", 578.5, 190000, dir_text_sat + "ariel.jpg", new Material(), Color.white, 2.52,2.52);
        astros.put(titania.getNombre(), titania);
        
        Astro miranda = new Satelite("miranda",236, 130000 ,dir_text_sat + "miranda.jpg", new Material(), Color.white, 1.41,1.41);
        astros.put(miranda.getNombre(), miranda);
        
        Astro triton = new Satelite("triton",1353.5, 354760, dir_text_sat + "triton.jpg", new Material(), Color.white, -5.88,-5.88);
        astros.put(triton.getNombre(), triton);
        
        // *******************************************************************/
        //Planetas
        // distancia respecto al sol expresados en millones de km
        // radio expresado en km
        // rotación y traslación expresados en días
        // *******************************************************************/
        
        Astro mercurio = new Planeta("mercurio", 2439.7, 57.8, dir_text_pla + "mercurio.jpg", new Material(), Color.white, 58.6, 87.6, (Estrella) sol, null);
        Astro venus = new Planeta("venus",60500, 108.2, dir_text_pla + "venus.jpg", new Material(), Color.white, 243 , 224.5, (Estrella) sol, null);
        Astro tierra = new Planeta("tierra", 6378, 149.6, dir_text_pla + "tierra.jpg", new Material(), Color.white, 1, 365.25, (Estrella) sol, new HashMap());
            ((Planeta) tierra).addSatelite((Satelite) luna);
        Astro marte = new Planeta("marte", 3393.5, 227.9, dir_text_pla + "marte.jpg", new Material(), Color.white, 1.03, 686.6, (Estrella) sol, new HashMap());
            ((Planeta) marte).addSatelite((Satelite) fobos);
            ((Planeta) marte).addSatelite((Satelite) deimos);
        Astro jupiter = new Planeta("jupiter",71492, 778.5, dir_text_pla + "jupiter.jpg", new Material(), Color.white, 0.414, 4331.86, (Estrella) sol, new HashMap());
            ((Planeta) jupiter).addSatelite((Satelite) io);
            ((Planeta) jupiter).addSatelite((Satelite) europa);
            ((Planeta) jupiter).addSatelite((Satelite) calisto);
        Astro saturno = new Planeta("saturno",60268, 1433, dir_text_pla + "saturno.jpg", new Material(), Color.white, 0.426, 10760.27, (Estrella) sol, null);
            // añadir anillo A
            // añadir anillo B
            // añadir anillo C
        Astro urano = new Planeta("urano", 25554, 2877, dir_text_pla + "urano.jpg", new Material(), Color.white, 0.718, 30684, (Estrella) sol, new HashMap());
            ((Planeta) urano).addSatelite((Satelite) titania);
            ((Planeta) urano).addSatelite((Satelite) ariel);
            ((Planeta) urano).addSatelite((Satelite) miranda);
        Astro neptuno = new Planeta("neptuno", 24769, 4498, dir_text_pla + "neptuno.jpg", new Material(), Color.white, 0.6745, 60189, (Estrella) sol, new HashMap());
            ((Planeta) neptuno).addSatelite((Satelite) triton);
    }

    
    
    
    public void createUniverso(){

        ViewingPlatform viewnzgPlatform = new ViewingPlatform ( ) ;

      

       // Branch de planetas
        BranchGroup planetas = new BranchGroup();
        
        // Enganchar los planetas al universo
        addBranchGraph(planetas);
        
        /*************/
        /* PLANETAS */
        /***********/
        
        /* Mercurio */
        
        // Mercurio es transformable
        TransformGroup conjuntoMercurio = new TransformGroup ();
        conjuntoMercurio.setCapability(TransformGroup .ALLOW_TRANSFORM_WRITE);
        
        // Enganchar conjuntoMercurio del branch de planetas
        planetas.addChild(conjuntoMercurio);
        //conjuntoMercurio.setTransform(Transformacion);
        
        /* Venus */
        
        // Venus es transformable
        TransformGroup conjuntoVenus = new TransformGroup ();
        conjuntoMercurio.setCapability(TransformGroup .ALLOW_TRANSFORM_WRITE);
        
        // Enganchar conjuntoVenus del branch de planetas
        planetas.addChild(conjuntoVenus);
        //conjuntoVenus.setTransform(Transformacion);
        
        /* Tierra */
        
        // Tierra es transformable
        TransformGroup conjuntoTierra = new TransformGroup ();
        conjuntoMercurio.setCapability(TransformGroup .ALLOW_TRANSFORM_WRITE);
        
        // Enganchar conjuntoTierra del branch de planetas
        planetas.addChild(conjuntoTierra);
        //conjuntoTierra.setTransform(Transformacion);
        
    }

}