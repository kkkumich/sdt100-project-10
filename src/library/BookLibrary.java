package library;
import books.Book;
public class BookLibrary {
    private Book[] books=new Book[100]; private int count=0;
    public int size(){return count;}
    public Book get(int i){if(i<0||i>=count)throw new IllegalArgumentException("Invalid index");return books[i];}
    public void add(Book book){if(book==null)throw new IllegalArgumentException("Null book");if(count==books.length)throw new IllegalArgumentException("Library full");books[count++]=book;}
    public void printOne(int i){System.out.println((i+1)+". "+get(i).getDescription());}
    public void print(){for(int i=0;i<count;i++)printOne(i);if(count==0)System.out.println("No books.");}
    public void find(String s){for(int i=0;i<count;i++)if(books[i].getTitle().toLowerCase(java.util.Locale.ROOT).contains(s.toLowerCase(java.util.Locale.ROOT)))printOne(i);}
    public void findByYear(int year){for(int i=0;i<count;i++)if(books[i].getYear()==year)printOne(i);}
    public void sort(){for(int end=count-1;end>0;end--){boolean swapped=false;for(int j=0;j<end;j++)if(books[j].getYear()>books[j+1].getYear()){
        Book temp=books[j];books[j]=books[j+1];books[j+1]=temp;swapped=true;
    }if(!swapped)break;}}
}
