package part2_library;

import books.Book;
import library.BookLibrary;
import common.Input;
public class Main {
    public static void inputItems(BookLibrary library){
        do {String title=Input.text("Title: ");String author=Input.text("Author: ");int year=Input.integer("Year: ",1,9999);int pages=Input.integer("Pages: ",1,1000000);library.add(new Book(title,author,year,pages));}while(Input.again());
    }
    public static void search(BookLibrary library){library.find(Input.text("Title contains: "));}
    public static void sort(BookLibrary library){library.sort();System.out.println("Sorted by year.");}
    public static void main(String[] args){BookLibrary library=new BookLibrary();while(true){
        System.out.println("1 Add | 2 Print | 3 Sort by year | 4 Find title | 5 Find year | 0 Exit");
        try {switch(Input.integer("Choose: ",0,5)){
            case 0:return;case 1:inputItems(library);break;case 2:library.print();break;case 3:sort(library);break;case 4:search(library);break;case 5:library.findByYear(Input.integer("Year: ",1,9999));break;
        }}catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }}
}
