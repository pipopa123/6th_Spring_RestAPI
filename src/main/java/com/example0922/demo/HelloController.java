package com.example0922.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String, String> hello() {
        //まどかとエミリーのバッグリストを作成し、それぞれの情報を取り出す。
        List<Bag> madokaBagList = List.of(
                new Bag("YSL", "pink"),
                new Bag("Dior", "white"));
        List<Bag> emilyBagList = List.of(
                new Bag("Hermese", "while"),
                new Bag("Prada", "black"));

        Map<String, String> responseBag = new HashMap<>();
        //まどかの情報
        StringBuilder madokaBuilder = new StringBuilder();
        for (Bag madokaFavoriteBag : madokaBagList) {
            String bagInfo="お気に入りのバッグは"+ madokaFavoriteBag.getColor() + "色の" +
                    madokaFavoriteBag.getBrandName() + "のバッグです";
            madokaBuilder.append(bagInfo).append("\n");

//インファーフェイスで定義したwearメソッドを呼び出す
            String wearResult = madokaFavoriteBag.wear();
            madokaBuilder.append(wearResult).append("\n");

        }
        //エミリーの情報
        StringBuilder  emilyBuilder= new StringBuilder();
        for(Bag emilyFavoriteBag:emilyBagList){
            String bagInfo="お気に入りのバッグは"+ emilyFavoriteBag.getColor() + "色の" +
                    emilyFavoriteBag.getBrandName() + "のバッグです";
            emilyBuilder.append(bagInfo).append("\n");
//インファーフェイスで定義したwearメソッドを呼び出す
            String wearResult = emilyFavoriteBag.wear();
            emilyBuilder.append(wearResult).append("\n");

        }
        responseBag.put("Madoka",madokaBuilder.toString());
        responseBag.put("Emily",emilyBuilder.toString());
        return responseBag;

    }
    @PostMapping("/hello")
    public Map<String ,String>postHello(@RequestBody Bag bag){
        Map<String,String >responseBag =new HashMap<>();
        StringBuilder responseBuilder = new StringBuilder();
        String bagInfo="お気に入りのバッグは"+bag.getColor()+"色の"+
                bag.getBrandName()+"のバッグです";
        responseBuilder.append(bagInfo).append("\n");
        String wearResult =bag.wear();
        responseBuilder.append(wearResult).append("\n");

        responseBag.put("Response",responseBuilder.toString());
        return responseBag;

    }
}