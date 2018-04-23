package nk.movies.controller;


import nk.movies.domain.Movie;
import nk.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MovieFEController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Movie movie, BindingResult bind){
        if (bind.hasErrors()){
            return "movieForm";
        }
        else {
            movieService.add(movie);
            model.addAttribute("movies", movieService.findAll());
            return "allMovies";
        }
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("movie", new Movie());
        return "movieForm";
    }
    @RequestMapping("/showAll")
    public String findAll(Model model){
        model.addAttribute("trips", movieService.findAll());
        return "allMovies";
    }

    @RequestMapping("/find")
    public String find(){
        return "findOne";
    }
    @RequestMapping("/findOneDetails")
    public String showDetailsForOneId(Model model, @RequestParam(value = "movieID") Long id){
        model.addAttribute("movieDetails", movieService.showDetailsForOneId(id));
        return "movieDetails";
    }



    }
