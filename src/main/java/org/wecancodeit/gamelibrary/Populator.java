package org.wecancodeit.gamelibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.gamelibrary.Models.BoardGameModel;
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private BoardGameRepository bRepository;

    @Resource
    private PublisherRepository pRepository;

    public Populator(BoardGameRepository bRepository, PublisherRepository pRepository) {
        this.bRepository = bRepository;
        this.pRepository = pRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        PublisherModel publisher1 = new PublisherModel("Days of Wonder");
        pRepository.save(publisher1);

        PublisherModel publisher2 = new PublisherModel("Stonemaier Games");
        pRepository.save(publisher2);

        PublisherModel publisher3 = new PublisherModel("Hasbro");
        pRepository.save(publisher3);

        PublisherModel publisher4 = new PublisherModel("Spin Master");
        pRepository.save(publisher4);

        BoardGameModel game1 = new BoardGameModel(
                "SmallWorld",
                "Control one fantasy race after another to expand throught the land",
                "https://cf.geekdo-images.com/aoPM07XzoceB-RydLh08zA__imagepage/img/lHmv0ddOrUvpiLcPeQbZdT5yCEA=/fit-in/900x600/filters:no_upscale():strip_icc()/pic428828.jpg",
                publisher1);
        bRepository.save(game1);
        BoardGameModel game2 = new BoardGameModel(
                "WingSpan",
                "Attract a beautiful and diverse collection of birds to your wildlife preserve.",
                "https://cf.geekdo-images.com/yLZJCVLlIx4c7eJEWUNJ7w__imagepagezoom/img/yS4vL6iTCvHSvGySxyOjV_-R3dI=/fit-in/1200x900/filters:no_upscale():strip_icc()/pic4458123.jpg",
                publisher2);
        bRepository.save(game2);
         BoardGameModel game3 = new BoardGameModel(
                "Trouble",
                "Hasbro Gaming Trouble Board Game for Kids Ages 5 and Up 2-4 Players",
                "https://m.media-amazon.com/images/I/81MdgnO4l9L._AC_UL400_.jpg",
                publisher3);
        bRepository.save(game3);
        BoardGameModel game4 = new BoardGameModel(
                "Candy Land",
                "Hasbro Gaming Candy Land Kingdom Of Sweet Adventures Board Game For Kids Ages",
                "https://m.media-amazon.com/images/I/91yUG40gv0L._AC_UL400_.jpg",
                publisher3);
        bRepository.save(game4);
        BoardGameModel game5 = new BoardGameModel(
                "Ticket to ride",
                "Ticket to Ride Board Game | Family Board Game | Board Game for Adults and Family",
                "https://m.media-amazon.com/images/I/91YNJM4oyhL._AC_UL400_.jpg",
                publisher1);
        bRepository.save(game5);
         BoardGameModel game6 = new BoardGameModel(
                "Sorry",
                "SORRY Classic Family Board Game Indoor Outdoor Retro Party Activity Summer Toy with Oversized Gameboard",
                "https://m.media-amazon.com/images/I/81ItkRyOaaL._AC_UL400_.jpg",
                publisher4);
        bRepository.save(game6);

    }

}

