package com.example.demo.overschot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service

public class RestoDB implements RestoInt {
    ArrayList<Resto> restos;

    public RestoDB() {
        restos = new ArrayList<Resto>();
        restos.add(new Resto("Alma 1", "Tiensestraat 115","3.9/5"));
        restos.add(new Resto("Alma 2", "E. Van Evenstraat 2","4.5/5"));
        restos.add(new Resto("Alma 3", "Steengroevenlaan 3","4.1/5"));

    }

    public ArrayList<Resto> getRestos() {
        return restos;
    }

    public ArrayList<Resto> getRestoArraylist(){
        return restos;
    }
}
