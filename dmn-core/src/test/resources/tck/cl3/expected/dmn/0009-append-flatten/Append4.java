
import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = {"decision.ftl", "append4"})
@com.gs.dmn.runtime.annotation.DRGElement(
    namespace = "",
    name = "append4",
    label = "",
    elementKind = com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
    expressionKind = com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
    hitPolicy = com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
    rulesCount = -1
)
public class Append4 extends com.gs.dmn.runtime.DefaultDMNBaseDecision {
    public static final com.gs.dmn.runtime.listener.DRGElement DRG_ELEMENT_METADATA = new com.gs.dmn.runtime.listener.DRGElement(
        "",
        "append4",
        "",
        com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
        com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
        com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
        -1
    );
    private final LiteralNestedList literalNestedList;
    private final LiteralSimpleList literalSimpleList;

    public Append4() {
        this(new LiteralNestedList(), new LiteralSimpleList());
    }

    public Append4(LiteralNestedList literalNestedList, LiteralSimpleList literalSimpleList) {
        this.literalNestedList = literalNestedList;
        this.literalSimpleList = literalSimpleList;
    }

    public List<List<String>> apply(com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_) {
        return apply(annotationSet_, new com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), new com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor());
    }

    public List<List<String>> apply(com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        try {
            // Decision start
            long startTime_ = System.currentTimeMillis();
            com.gs.dmn.runtime.listener.Arguments arguments_ = new com.gs.dmn.runtime.listener.Arguments();
            eventListener_.startDRGElement(DRG_ELEMENT_METADATA, arguments_);

            // Apply child decisions
            List<List<String>> literalNestedListOutput = literalNestedList.apply(annotationSet_, eventListener_, externalExecutor_);
            List<String> literalSimpleListOutput = literalSimpleList.apply(annotationSet_, eventListener_, externalExecutor_);

            // Evaluate expression
            List<List<String>> output_ = evaluate(literalNestedListOutput, literalSimpleListOutput, annotationSet_, eventListener_, externalExecutor_);

            // Decision end
            eventListener_.endDRGElement(DRG_ELEMENT_METADATA, arguments_, output_, (System.currentTimeMillis() - startTime_));

            return output_;
        } catch (Exception e) {
            logError("Exception caught in 'append4' evaluation", e);
            return null;
        }
    }

    private List<List<String>> evaluate(List<List<String>> literalNestedList, List<String> literalSimpleList, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        return append(literalNestedList, literalSimpleList);
    }
}
