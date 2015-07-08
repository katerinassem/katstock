/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 * Helps to render static templates from external files
 * USAGE:
 * var rendered_html;
 * render("home", "resources/app/js/home/template/", ".html", {}, function(data) {rendered_html = data;});
 */

function render(templateName, templatePrefix, templateSuffix, templateData, successCallback) {

    if (!render.templateCache) {
        render.templateCache = {};
    }

    if (!render.templateCache[templateName]) {
        var templateUrl = templatePrefix + templateName + templateSuffix;
        var templateContent;

        $.ajax({
            url: templateUrl,
            method: 'GET',
            success: successCallback
        });

    }
    else {
        successCallback(render.templateCache[templateName])(templateData);
    }
}