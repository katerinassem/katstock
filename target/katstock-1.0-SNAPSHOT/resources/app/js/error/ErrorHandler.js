/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 *
 * Sets up rules for handling ajax errors
 */
Backbone.$.ajaxSetup({

    statusCode : {

        401 : function() {
            console.log("status 401 - unauthorized");
            Backbone.history.navigate("login", true);
        },
        403 : function() {
            console.log("status 403 - forbidden");
            Backbone.history.navigate("login", true);
        },
        200 : function() {
            console.log("status 200 - ok");
        },
        302 : function() {
            console.log("302 - found");
            Backbone.history.navigate("/", true);
        }
    }
});