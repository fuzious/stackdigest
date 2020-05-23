package com.stackDigest.stackDigest.beans.restfetch.userFetch;

import java.util.List;

public class JsonRootBeanUser {

    private List<Items> items;
    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

}
