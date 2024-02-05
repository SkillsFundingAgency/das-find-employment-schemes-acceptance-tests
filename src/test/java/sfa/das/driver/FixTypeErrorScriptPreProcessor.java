package sfa.das.driver;

import org.apache.commons.lang3.StringUtils;
import org.htmlunit.ScriptPreProcessor;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

public class FixTypeErrorScriptPreProcessor implements ScriptPreProcessor {
    private final ScriptPreProcessor nextScriptPreProcessor_;

    public FixTypeErrorScriptPreProcessor() {
        nextScriptPreProcessor_ = null;
    }

    public FixTypeErrorScriptPreProcessor(final ScriptPreProcessor nextScriptPreProcessor) {
        nextScriptPreProcessor_ = nextScriptPreProcessor;
    }

    @Override
    public String preProcess(final HtmlPage htmlPage, final String sourceCode, final String sourceName,
                             final int lineNumber, final HtmlElement htmlElement) {

        String patchedSourceCode = sourceCode;

        if (sourceName.contains("/site.js") && !sourceName.contains("/site.js#")) {
            patchedSourceCode = StringUtils.replace(
                    sourceCode,
                    "var t=this,i=t.getAttribute(\"data-menu-section\");const n=document.querySelector('.govuk-header__navigation-item[data-menu-section=\"'+i+'\"]');",
                    "var t=this,ix=t.getAttribute(\"data-menu-section\");const n=document.querySelector('.govuk-header__navigation-item[data-menu-section=\"'+ix+'\"]');");
        }

        if (nextScriptPreProcessor_ != null) {
            return nextScriptPreProcessor_.preProcess(htmlPage, patchedSourceCode, sourceName, lineNumber, htmlElement);
        }

        return patchedSourceCode;
    }
}
