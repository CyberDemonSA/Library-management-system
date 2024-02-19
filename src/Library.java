import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library extends Object implements Serializable {
    private List<Books> collection;

    public Library(){
        List<Books> collection = new ArrayList<Books>();

    }

    public void addbook(Books book){
        collection.add(book);
    }

    @Override
    public String toString() {
        String total = "\n";
//        for (int i=0; i<collection.size(); i++){
//            Books b = collection.get(i);
//            total = total + b.toString();
//        }
        Iterator<Books> i = collection.iterator();
        while (i.hasNext()){
            Books b = (Books) i.next();
            total = total + b.toString();
        }
    return total;
    }
}
