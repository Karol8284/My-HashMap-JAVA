package hashMap;
import java.util.ArrayList;
import java.util.HashMap;
public class MyHashMap {
    ArrayList indexes = new ArrayList<>();
    ArrayList values = new ArrayList<>();
    Object index,value;
    MyHashMap(){}
    public void set(Object index, Object value){
        indexes.add(indexes.size(),index);
        values.add(indexes.size()-1,value);
    }
    public Object get(Object element) {
        Integer i = getIndexFromArray(indexes, element);
        this.value = getValueFromArray(values,i);
        return value;
    }
    public boolean delete(Object deleteIndex){
        Integer i = getIndexFromArray(indexes, deleteIndex);
        deleteFromArray(indexes,i);
        deleteFromArray(values,i);
        return true;
    }
    public Integer size(){
        return indexes.size();
    }
    private Integer getIndexFromArray(ArrayList array, Object element){
        Integer i = 0;
        for(Object o : array){
            if (element.equals(o))return i;
            i++;
        }
        return null;
    }
    private Object getValueFromArray(ArrayList array, Integer index){
        Integer i = 0;
        for(Object o : array){
            if (i == index)return o;
            i++;
        }
        return null;
    }
    private boolean deleteFromArray(ArrayList array, Object deleteIndex){
        Integer i = 0;
        for(Object o : array){
            if (deleteIndex == i){
                array.remove(o);
                return true;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        HashMap hm = new HashMap<>();
        MyHashMap m = new MyHashMap();
        String a = "a";
        String b = "b";
        Integer c = 2123;
        Integer d = 42343652;

        m.set(a,c);
        m.set(b,d);
        m.set(123,"Karol");

        m.get("a");
        m.get(123);

        System.out.println("ArrayList indexes: "+ m.indexes);
        System.out.println("ArrayList values: "+ m.values);

        System.out.println(m.delete(123));
        m.get(123);
        System.out.println(m.indexes);
        System.out.println(m.values);
        m.set(123,"1111111111111111");
        System.out.println(m.indexes);
        System.out.println(m.values);
        System.out.println("SIZE: "+ m.size());
    }
}
