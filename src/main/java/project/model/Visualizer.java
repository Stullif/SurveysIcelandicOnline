package project.model;

/**
 * Created by gudkj on 10/12/2015.
 */
public class Visualizer {

    private Survey data = new Survey();
    private Visualisation v = null;


    public Visualizer(Survey d, int options){
        this.data = d;
        visualize(this.data, options);
    }

    public void visualize(Survey d, int o){
        this.v = new Visualisation(d,o);
    }
}
