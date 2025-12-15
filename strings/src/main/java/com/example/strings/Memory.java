package com.example.strings;

import java.lang.reflect.ParameterizedType;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Memory {
    int pageSize;
    int numPages;
    List<Page> pages;
    List <Integer> freePages;

    Memory(int pageSize,int numPages){
        this.pageSize = pageSize;
        this.numPages = numPages;
        this.pages = new ArrayList<>();
        this.freePages = new ArrayList<>();
        for (int i=0;i<numPages;i++){
            Page page = new Page(pageSize);
            pages.add(page);
            freePages.add(i);
        }
    }
    int allocatePage(){
        if (freePages.isEmpty()){
            return -1;
        }
        int pageIndex = freePages.remove(0);
        return pageIndex;
    }
    void deallocatePage(int pageIndex){
        freePages.add(pageIndex);
    }
    byte[] readPage(int pageIndex){
        if (pageIndex<0 || pageIndex>=numPages){
            return null;
        }
        Page page = pages.get(pageIndex);
        return page.getBytes();
    }
    void writePage(int pageIndex,byte[] data){

        if (pageIndex<0 || pageIndex>=numPages){
            return;
        }
        Page page = pages.get(pageIndex);
        page.setBytes(data);
    }
}
class Page{
    byte[] bytes;

    Page(int size){
        this.bytes = new byte[size];
    }
    byte[] getBytes(){
        return bytes;
    }
    void setBytes(byte[] data){
        System.arraycopy(data,0,bytes,0,data.length);
    }
}
 class Test {
    public static void main(String[] args) {
        Memory mem = new Memory(1024,4);
        int pageIndex = mem.allocatePage();
        byte[] data = "Hello, world!".getBytes();
        mem.writePage(pageIndex,data);
        byte[]  readData = mem.readPage(pageIndex);
        System.out.println(new String(readData));
        mem.deallocatePage(pageIndex);
    }
}

