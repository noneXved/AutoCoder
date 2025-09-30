public class UserRegistrationController {
    @Autowired
    private UserValidator userValidator;
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        // Process registration logic
        return "redirect:/home";
    }
}
