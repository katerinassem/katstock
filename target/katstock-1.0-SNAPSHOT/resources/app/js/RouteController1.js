/**
 * Created by katsiaryna.siamikina on 06.07.2015.
 */
var Controller = Backbone.Router.extend({

    routes : {
        "" : "start", // ������ hash-���
        "!/" : "start",
        "!/click" : "click"
    },

    start : function () {
    },

    click : function () {
        click.render();
    }
});

var controller = new Controller(); // ������ ����������

Backbone.history.start();  // ��������� HTML5 History push