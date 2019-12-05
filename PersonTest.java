

import java.util.Scanner;

/*
    Yapýlacaklar:
    1- Menü için bir sürekli döngü
    2-Ekleme
    3-Silme
    4-Deðiþtirme
    5-Listeleme
    6-Detay Görüntüleme
    7-Ara
    8-Kapat
*/

public class PersonTest 
{
    static Person[] persons;
    static Scanner scn = new Scanner(System.in);
    static int freeIndex = 3;
    static Person p1=new Person("Ömer","Karakaþ",1992,'E');
    static Person p2=new Person("Furkan","Karagöz",1995,'E');
    static Person p3=new Person("Bengisu","Özmelleþ",1997,'K');
    

    
    //isimleri listeleyen method:
    public static void listele()
    {
        System.out.println("\nMevcut Liste :");
        persons[0]=p1;
        persons[1]=p2;
        persons[2]=p3;
      
        for(int i = 0; i<persons.length; i++)
        {
            if(persons[i] != null)
                System.out.println((i+1) + " - " + persons[i].getName() + " " + persons[i].getSurname()); 
        }
    }
    
    //Yeni kiþi ekleyen method:
    public static void ekle()
    {
        Person p = new Person();
        String line;
        System.out.print("Ekleme(Ad Soyad Cinsiyet(E/K) Doðum Yýlý):");
        line = scn.nextLine();
        line = scn.nextLine();
        String[] data = line.split(" ");
        p.setName(data[0]);
        p.setSurname(data[1]);
        p.setGender(data[2].charAt(0));
        p.setBirthDay(Integer.parseInt(data[3]));
       
        if(freeIndex<persons.length && freeIndex >= 0)
        {
            persons[freeIndex] = p;
            System.out.println(p.getName() + " eklendi \n");
            freeIndex++;
        }
        else if(freeIndex == persons.length)
        {
            Person[] temp = new Person[persons.length + 1];
            copy(temp, persons);
            temp[freeIndex] = p;
            freeIndex++;
            persons = temp;
        }
       listele();
    }
    
    public static void copy(Person[] _new, Person[] _old)
    {
        //silme öncesi kopyalama:
        if(_new.length < _old.length)
        {
            int index = 0;
            for(int i = 0; i < _new.length; i++)
            {
                if(_old[i] != null)
                {
                    _new[index] = _old[i];
                    index++;
                }
            }
         //Ekleme öncesi kopyalama:
        }else if(_new.length > _old.length)
        {
            for(int i = 0; i < _old.length; i++)
            {
                    _new[i] = _old[i];
            }
        }
    }
    
    public static void sil()
    {
        Person[] temp = new Person[persons.length-1];
        String isim = "";
        System.out.print("Silinecek kiþinin ismi: ");
        isim = scn.next();
        System.out.println();
        int index = -1;
        for(int i = 0; i < persons.length && persons[i] != null; i++)
        {
            if(persons[i].getName().equals(isim))
                index = i;
        }
        if(index >= 0)
        {
            persons[index] = null;
            copy(temp, persons);
            persons = temp;
            freeIndex--;
        }
        listele();
    }
    
    public static void degistir()
    {
        int index = -1;
        System.out.println("\nDeðiþtirilecek kiþinin indeksi: ");
        index = scn.nextInt();
        index--;
        
        if(index >= 0 && index < persons.length && persons[index] != null)
        {
            System.out.println("Deðiþtirilecek kiþinin bilgileri:");
            System.out.print(persons[index].getName() + " " + persons[index].getSurname() + ", " + persons[index].getBirthDay() + ", " + persons[index].getGender());
            String line="";
            System.out.println("\nYeni Bilgiler(Ad Soyad Cinsiyet Doðum Yýlý):");
            line = scn.nextLine();//isim için
            line = scn.nextLine();//soyisim için
            String[] data = line.split(" ");
            persons[index].setName(data[0]);
            persons[index].setSurname(data[1]);
            persons[index].setGender(data[2].charAt(0));
            persons[index].setBirthDay(Integer.parseInt(data[3]));
        }
        listele();
    }
    
    public static void detay()
    {
        int index = -1;
        System.out.println("\nDetay bilgileri gösterilecek kiþinin indeksi: ");
        index = scn.nextInt();
        index--;
        
        if(index >= 0 && index < persons.length && persons[index] != null)
        {
            System.out.print(persons[index].getName() + " " + persons[index].getSurname() + ", " + persons[index].getBirthDay() + ", " + persons[index].getGender());
        }
    }
    
    public static void ara()
    {
        String arama = "";
        System.out.print("Arama: ");
        arama = scn.next();
        System.out.println("Bulunanlar: ");
        for(int i = 0; i<persons.length && persons[i] != null; i++)
        {
            if(persons[i].getName().contains(arama) || persons[i].getSurname().contains(arama))
            {
                System.out.println("\n" + (i+1) + " - " + persons[i].getName() + " " + persons[i].getSurname() + ", " + persons[i].getBirthDay() + ", " + persons[i].getGender());
            }
        }
    }
    public static void printMenu()
    {
        System.out.println();
        System.out.println(
                "(MENU)"
                        + "\n"
                        + "Ekle            (E)\n"
                        + "Sil             (S)\n"
                        + "Deðiþtir        (D)\n"
                        + "Listele         (L)\n"
                        + "Detay Görüntüle (G)\n"
                        + "Ara             (A)\n"
                        + "Çýkýþ           (Ç)\n"
        );
    }
    public static void main(String[] args) 
    {
        char secim = 'L';
        persons = new Person[50];
        listele();
        
     
        while(secim != 'Ç')
        {
            printMenu();
            System.out.print("Seçim: ");
            secim = scn.next().charAt(0);
            System.out.println();
            switch(secim)
            {
                case 'E' :
                    ekle();
                break;
                
                case 'S' :
                    sil();
                break;
                
                case 'D' :
                    degistir();
                break;
                
                case 'L':
                    listele();
                break;
                
                case 'G' :
                    detay();
                break;
                
                case 'A' :
                    ara();
                break;
                case 'Ç' :
                    System.out.println("Güle Güle");
                  
                break;
            }
        }
    }
}
