/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
var Authentication = Backbone.Model.extend( {

    url : function() {
        return "login?email=" + this.email + "&password=" + this.password;
    },

    setCredentials : function(email, password) {
        this.email = email;
        this.password = password;
    }

});