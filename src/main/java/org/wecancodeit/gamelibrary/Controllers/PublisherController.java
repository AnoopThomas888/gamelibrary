package org.wecancodeit.gamelibrary.Controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.PublisherRepository;

import jakarta.annotation.Resource;

@Controller
public class PublisherController {

    @Resource
    private PublisherRepository repository;

    public PublisherController(PublisherRepository repository) {
        this.repository = repository;
    }

    @RequestMapping({ "", "/", "/publisher" })
    public String getAllPublishers(Model model) {
        model.addAttribute("publishers", repository.findAll());
        return "displayPublisherView";
    }

    @GetMapping("/publisher/gameDetails/{id}")
    public String getPublisherDetails(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", repository.findById(id).get());
        return "gameDetailsView";

    }

    @GetMapping("/publisher/Deletepublisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model) {

        repository.deleteById(id);

        return "redirect:/publisher";
    }

    @GetMapping("/publisher/EditPublisher/{id}")
    public ModelAndView editPublisher(@PathVariable Long id, PublisherModel publisher) {
        ModelAndView mav = new ModelAndView("createPublisherForm");
publisher=repository.findById(id).get();
        repository.save(publisher);

        return mav;
    }

    @GetMapping("/publisher/create/")
    public ModelAndView createPublisher(String name) {

        // repository.save(new PublisherModel(name));
        ModelAndView mav = new ModelAndView("createPublisherForm");
        PublisherModel newPublisher = new PublisherModel(name);
        mav.addObject("PublisherModel", newPublisher);
        return mav;
    }

    @PostMapping("/savePublisher")
    public String savePublisher(@ModelAttribute PublisherModel publisher) {
        repository.save(publisher);
        return "redirect:/publisher";
    }
}
