import com.Node;
import com.Reis;
import com.Rit;
import com.Vlucht;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;


class ReisTest {
    @Test
    void testKortstePad(){
        // nodes
        Node s0 = new Node("Rhenen");
        Node s1 = new Node("Utrecht");
        Node s2 = new Node("Amsterdam");
        Node s3 = new Node("Dordrecht");
        Node s4 = new Node("Den Haag");
        // overgangen met afstanden/gewichten
        s0.setOvergangen(new ArrayList<>(Arrays.asList(new Rit(s1, 50), new Rit(s2, 70))));
        s1.setOvergangen(new ArrayList<>(Arrays.asList(new Rit(s2, 40), new Rit(s3, 60),new Rit(s4, 70))));
        s2.setOvergangen(new ArrayList<>(Arrays.asList(new Rit(s4,65), new Rit(s3, 90))));
        s4.setOvergangen(new ArrayList<>(Collections.singletonList(new Rit(s3, 50))));

        Reis testReis = new Reis(s0, s4);

        // mogelijke paden zijn Rhenen ->50km Utrecht ->40km Amsterdam ->65km Den Haag == 155 km
        //                      Rhenen ->50km Utrecht ->70km Den Haag == 120 km
        assertEquals(120, s4.getGewichtVanafBegin());
        // mogelijke paden  zijn Rhenen -> 70km Amsterdam -> 90km Dordrecht = 160 km
        //                       Rhenen -> 50km Utrecht -> 60km Dordrecht = 110 km
        assertEquals(110, s3.getGewichtVanafBegin());

        // [Rhenen, Utrecht, Den Haag]
        assertEquals(new ArrayList<Node>(Arrays.asList(s0, s1, s4)), testReis.getKortstePad());
    }

    void testKortstePadVlucht(){
        // nodes
        Node s0 = new Node("Luchthaven 0");
        Node s1 = new Node("Luchthaven 1");
        Node s2 = new Node("Luchthaven 2");
        Node s3 = new Node("Luchthaven 3");
        // overgangen met afstanden/gewichten
        s0.setOvergangen(new ArrayList<>(Arrays.asList(new Vlucht(s1, 100), new Vlucht(s3, 400))));
        s1.setOvergangen(new ArrayList<>(Collections.singletonList(new Vlucht(s2, 100))));
        s2.setOvergangen(new ArrayList<>(Arrays.asList(new Vlucht(s3,100), new Vlucht(s0, 200))));

        Reis testReis = new Reis(s0, s3);

        // s0 -> 100 s1 -> 100 s2 -> 100 s3
        // s0 -> 400 s3
        // voor elke extra stap wordt een gewicht van 10 toegevoegd om meer overstappen een negatief invloed te laten krijgen

        assertEquals(450, s3.getGewichtVanafBegin());

        // [Luchthaven 0, Luchthaven 3]
        assertEquals(new ArrayList<Node>(Arrays.asList(s0, s3)), testReis.getKortstePad());
    }


}