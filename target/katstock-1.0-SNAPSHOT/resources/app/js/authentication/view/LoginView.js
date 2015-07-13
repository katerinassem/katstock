/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
var LoginView = Backbone.View.extend({

    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render : function() {

        Util.renderView(
            this,
            "login",
            "resources/app/js/authentication/template/",
            ".html",
            {}
        )
    },

    events : {
        "click #log-in-button" : "login"
    },

    login : function(){

        var authentication = new Authentication();
        authentication.setCredentials(
            $("#inputEmail").val(),
            $("#inputPassword").val()
        );

        var attributes = {
            "method": "POST"
        };
        var options = {
            error: function () {
                console.log("error authenication");
            },

            success: function () {
                console.log("success authentication");
            }
        };

        authentication.save(attributes, options)
            .always(function() {
                Application.updateHeader();
            });
    },

    init : function() {

    }

});