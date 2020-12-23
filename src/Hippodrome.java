
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

   private List<Horse> horses;

   static Hippodrome game;

   public List<Horse> getHorses () {
       return horses;
   }

   public Hippodrome (List<Horse> horses) {
       this.horses = horses;
   }

   public void run () throws InterruptedException {
       for (int i = 0; i < 100; i++) {
           move();
           print();
           Thread.sleep(200);
       }
   }

   void move () {
       for (Horse horse : horses) {
           horse.move();
       }
   }

   public void print () {
       for (Horse horse : horses) {
           horse.print();
       }
       for (int i = 0; i < 10; i++) {
           System.out.println();
       }
   }

   public Horse getWinner () {
      double max = horses.get(0).distance;
      Horse horse = horses.get(0);
      for (Horse h : horses) {
          if (h.distance > max) {
              max = h.distance;
              horse = h;
          }
      }
      return horse;
   }

   public void printWinner () {
       System.out.println("Winner is " + this.getWinner().name + "!");
   }
   
    public static void main(String[] args) throws InterruptedException {
       List<Horse> list = new ArrayList<>();
       list.add(new Horse("Mashka", 3, 0));
       list.add(new Horse("Zorka", 3, 0));
       list.add(new Horse("Boris", 3, 0));
       game = new Hippodrome(list);
       game.run();
       game.printWinner();
    }
}
