package com.szczepaniak.dawid.selecticon;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CardsDataBase cardsDataBase;
    private ArrayList<Card> cards;
    private Card mainCard;
    private Card playerCard;
    private View mainCardView;
    private View playerCardView;

    private boolean canClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout =  findViewById(R.id.layout);
        Random random = new Random();

        cardsDataBase =  new CardsDataBase();
        cards =  new ArrayList<>();

        for(Card card : cardsDataBase.getCards()){

            cards.add(card);
        }

        Card card1 = cards.get(random.nextInt(cards.size()));
        cards.remove(card1);

        Card card2 = cards.get(random.nextInt(cards.size()));
        cards.remove(card2);

        createCard(layout, false);
        createCard(layout, true);


    }

    void createCard(final LinearLayout layout, boolean isClickable){

        Random random = new Random();
        final Card card = cards.get(random.nextInt(cards.size()));
        cards.remove(card);

        final View cardView = getLayoutInflater().inflate(R.layout.card_layout, null, false);

        for(int i = 0; i < 8; i++){

            ImageView cardImg = cardView.findViewById(R.id.icon + (i + 1));
            cardImg.setRotation(random.nextInt(360));
            cardsDataBase.setIconImage(cardImg,card.getCardNumbers()[i]);
            final int imageIndex = i;
            if(isClickable) {

                playerCard = card;
                playerCardView = cardView;

                cardImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (canClick && v.getParent() == playerCardView) {
                            int clickedIndex = card.getCardNumbers()[imageIndex];
                            boolean isOk = false;

                            for (int number : mainCard.getCardNumbers()) {

                                if (number == clickedIndex) {
                                    isOk = true;
                                    break;
                                }
                            }

                            if (isOk) {

                                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.go_up);
                                animation.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {

                                        layout.removeView(mainCardView);
                                        mainCardView = playerCardView;
                                        mainCard = playerCard;
                                        createCard(layout, true);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                });

                                playerCardView.startAnimation(animation);

                            } else {
                                shakeAnimation(cardView);
                            }

                        }
                    }
                });
            }else {

                mainCard = card;
                mainCardView = cardView;

            }
        }

        cardView.setLayoutParams(new ViewGroup.LayoutParams(570, 570));
        cardView.setRotation(random.nextInt(360));
        AlphaAnimation intro = new AlphaAnimation(0.2f, 1.0f);
        intro.setDuration(1000);
        intro.setFillAfter(true);
        cardView.startAnimation(intro);
        layout.addView(cardView);
    }

    void shakeAnimation(View v){
        Animation animShake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
        animShake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                canClick = false;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                canClick = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(animShake);
    }
}
