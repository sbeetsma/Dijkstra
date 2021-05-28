import com.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;


class StapTest {
    // test dezelfde setup van object Stap ook met klassen die Stap extenden
    @Test
    void testStap(){
       // nodes
    Node s0 = new Node("s0");
    Node s1 = new Node("s1");
    Node s2 = new Node("s2");

        // overgangen met afstanden/gewichten
       s0.setOvergangen(new ArrayList<>(Arrays.asList(new Stap(s1, 10), new Stap(s2, 20))));
       s1.setOvergangen(new ArrayList<>(Collections.singletonList(new Stap(s2, 30))));
       s2.setOvergangen(new ArrayList<>(Collections.singletonList(new Stap(s1, 40))));

        assertEquals(2, s0.getOvergangen().size());
        // eerste overgang van s0 zou s1 moeten zijn
        assertEquals(s1, s0.getOvergangen().get(0).getBestemming());
        // eerste gewicht overgang van s2 naar s1 is 40
        assertEquals(30, s1.getOvergangen().get(0).getGewicht());

   }
    void testRit(){
        // nodes
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");

        // overgangen met afstanden/gewichten
        s0.setOvergangen(new ArrayList<>(Arrays.asList(new Rit(s1, 25), new Rit(s2, 20))));
        s1.setOvergangen(new ArrayList<>(Collections.singletonList(new Rit(s2, 10))));
        s2.setOvergangen(new ArrayList<>(Collections.singletonList(new Rit(s1, 40))));

        assertEquals(2, s0.getOvergangen().size());
        // eerste overgang van s0 zou s1 moeten zijn
        assertEquals(s1, s0.getOvergangen().get(0).getBestemming());
        // eerste gewicht overgang van s2 naar s1 is 10
        assertEquals(10, s1.getOvergangen().get(0).getGewicht());

    }
    void testTreinrit(){
        // nodes
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        // overgangen met afstanden/gewichten
        s0.setOvergangen(new ArrayList<>(Arrays.asList(new Treinrit(s1, 100), new Treinrit(s2, 200), new Treinrit(s3, 130))));
        s1.setOvergangen(new ArrayList<>(Collections.singletonList(new Treinrit(s2, 130))));
        s2.setOvergangen(new ArrayList<>(Collections.singletonList(new Treinrit(s1, 140))));

        assertEquals(3, s0.getOvergangen().size());
        // eerste overgang van s0 zou s1 moeten zijn
        assertEquals(s1, s0.getOvergangen().get(0).getBestemming());
        assertEquals(130, s1.getOvergangen().get(0).getGewicht());

    }

    void testVlucht(){
        // nodes
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");

        // overgangen met afstanden/gewichten
        s0.setOvergangen(new ArrayList<>(Arrays.asList(new Vlucht(s1, 500), new Vlucht(s2, 400))));
        s1.setOvergangen(new ArrayList<>(Collections.singletonList(new Vlucht(s2, 300))));
        s2.setOvergangen(new ArrayList<>(Collections.singletonList(new Vlucht(s1, 400))));

        // eerste overgang van s0 zou s1 moeten zijn
        assertEquals(s2, s1.getOvergangen().get(0).getBestemming());
        assertEquals(300, s1.getOvergangen().get(0).getGewicht());

    }



}