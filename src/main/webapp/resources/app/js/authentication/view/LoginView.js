/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
var LoginView = Backbone.View.extend({

    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render : function() {
        var instance = this;
        render(
            "login",
            "resources/app/js/authentication/template/",
            ".html",
            {},
            function(data){
                instance.template = data;
                instance.$el.html(instance.template);
            }
        )
    },

    events : {
        "click #log-in-button" : "login"
    },

    login : function(){
        var authentication = new Authentication( {
            email : $("#inputEmail").val(),
            password : $("#inputPassword").val()
        });
        authentication.save({
            "method" : "POST",
            "Content-type" : "application/json"
        });
    },

    init : function() {

    }

});