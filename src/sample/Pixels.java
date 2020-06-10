package sample;


import java.util.*;

//Class for save all dots in one collection
public class Pixels {
        public Vector<Dot> pixels;

        public Pixels()
        {
            pixels = new Vector<>();
        }

        public void add(Dot dot)
        {
            pixels.add(dot);
        }

        public Dot get(int index)
        {
            return pixels.get(index);
        }

        public void clear()
        {
            pixels.clear();
        }

        public int size()
        {
            return pixels.size();
        }

        public Iterator<Dot> getIterator()
        {
            return pixels.iterator();
        }


}
