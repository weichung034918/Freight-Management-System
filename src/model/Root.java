package model;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.List;

public class Root<T> {
    private List<T> root;

    public Root(){
        root = new ArrayList<T>();
    }

    public void add(T t){
        root.add(t);
    }

    public T get(int index){
        return root.get(index);
    }

    public int size(){
        return root.size();
    }

    public void remove(int index){
        root.remove(index);
    }

    public void remove(T t){
        root.remove(t);
    }

    @XmlAnyElement(lax = true)
    public List<T> getRoot() {
        return root;
    }

    public void setRoot(List<T> root) {
        this.root = root;
    }

}
