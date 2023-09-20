package org.wecancodeit.gamelibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wecancodeit.gamelibrary.Models.BoardGameModel;
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.BoardGameRepository;

import jakarta.annotation.Resource;

@Controller
public class GameController {
    @Resource
    public BoardGameRepository boardGameRepository;
    // @GetMapping("/publisher/gameDetails/{id}")
    // public String getPublisherDetails(@PathVariable Long id, Model model) {
    // model.addAttribute("publisher", boardGameRepository.findById(id).get());
    // return "gameDetailsView";
    // }
    BoardGameModel boardgame;

    public GameController(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    @GetMapping("/boardgame/Deletegame/{id}")
    public String deleteGame(@PathVariable Long id, Model model) {

        boardGameRepository.deleteById(id);

        return "redirect:/publisher/gameDetails/{id}";
    }

    @GetMapping("/publisher/gameDetails/game/create/")
    public ModelAndView createGame(String name ,String description,String imageurl,PublisherModel publisher) {

        // repository.save(new PublisherModel(name));
        ModelAndView mav = new ModelAndView("createGameForm");
        BoardGameModel newGame = new BoardGameModel(name, description, imageurl, publisher);
        mav.addObject("BoardGameModel", newGame);
        return mav;
    }

    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute BoardGameModel game) {

        boardGameRepository.save(game);
        return "redirect:/publisher/gameDetails/{id}";
    }

    @GetMapping("/boardgame/Editgame/{id}")
    public ModelAndView editPublisher(@PathVariable Long id, BoardGameModel game) {
        ModelAndView mav = new ModelAndView("createGameForm");
        game = boardGameRepository.findById(id).get();
        boardGameRepository.save(game);

        return mav;
    }

}