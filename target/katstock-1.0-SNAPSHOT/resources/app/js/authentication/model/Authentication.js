/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
var Authentication = Backbone.Model.extend( {

    url : function() {
        return "login?email=" + this.get("email") + "&password=" + this.get("password") + "&remember=" + this.get("rememberMe");
    }});