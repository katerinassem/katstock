/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */

var Application = (function() {

    var home = {};
    var Router = Backbone.Router.extend({

        routes : {
            "" : "home",
            "!/login" : "login"
        },

        home : function() {

            ///render home view
            var home = ViewsFactory.home();
            home.render();
        },

        login : function() {

            //render login view
            var login = ViewsFactory.login();
            login.render();
        }
    });

    var ViewsFactory = {

        home : function() {
            return new HomeView();
        },

        login : function() {
            return new LoginView();
        }
    };

    var Api = {

        init : function() {
            Api.router = new Router();
            Backbone.history.start();
        },

        constants : {
            PARTIAL_VIEW_SELECTOR : "#partial-view"
        }
    };

    return Api;

})();

window.onload = function() {
    Application.init();
};