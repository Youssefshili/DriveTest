package com.example.chaima.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PrisonerContent {

    /**
     * An array of sample (Prisoner) items.
     */
    public static ArrayList<PrisonerItem> ITEMS = new ArrayList<PrisonerItem>();

    /**
     * A map of sample (Prisoner) items, by ID.
     */
    public static Map<String, PrisonerItem> ITEM_MAP = new HashMap<String, PrisonerItem>();

    static {
        addItem(new PrisonerItem("1", "911", "Pablo Escobar", R.drawable.escobar, "Rionegro, Colombia"));
        addItem(new PrisonerItem("2", "912", "Alphonse Gabriel Capone", R.drawable.elcapone, "Brooklyn, New York, USA"));
        addItem(new PrisonerItem("3", "913", "Joaquín Guzmán", R.drawable.elchapo, "Sinaloa, México"));
        addItem(new PrisonerItem("4", "914", "Michael Gordon Peterson", R.drawable.bronson, "Wales, UK"));
        addItem(new PrisonerItem("5", "915", "Thomas Edward Silverstein", R.drawable.tommy, "Long Beach, California, USA"));
    }

    private static void addItem(PrisonerItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A PrisonerItem representing a piece of content.
     */
    public static class PrisonerItem {
        public String id;
        public String matricule;
        public String name;
        public int smallPictureId;
        public String address;

        public PrisonerItem(String id, String matricule, String name, int smallPictureId, String address) {
            super();
            this.id = id;
            this.matricule = matricule;
            this.name = name;
            this.smallPictureId = smallPictureId;
            this.address = address;
        }

        @Override
        public String toString() {
            return name;
        }


    }
}