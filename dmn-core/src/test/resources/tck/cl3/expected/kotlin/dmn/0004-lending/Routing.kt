
import java.util.*
import java.util.stream.Collectors

@javax.annotation.Generated(value = ["decision.ftl", "Routing"])
@com.gs.dmn.runtime.annotation.DRGElement(
    namespace = "",
    name = "Routing",
    label = "",
    elementKind = com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
    expressionKind = com.gs.dmn.runtime.annotation.ExpressionKind.INVOCATION,
    hitPolicy = com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
    rulesCount = -1
)
class Routing(val postBureauAffordability : PostBureauAffordability = PostBureauAffordability(), val postBureauRiskCategory : PostBureauRiskCategory = PostBureauRiskCategory()) : com.gs.dmn.runtime.DefaultDMNBaseDecision() {
    fun apply(applicantData: String?, bureauData: String?, requestedProduct: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet): String? {
        return try {
            apply(applicantData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TApplicantDataImpl::class.java) }), bureauData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TBureauDataImpl::class.java) }), requestedProduct?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TRequestedProductImpl::class.java) }), annotationSet_, com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor())
        } catch (e: Exception) {
            logError("Cannot apply decision 'Routing'", e)
            null
        }
    }

    fun apply(applicantData: String?, bureauData: String?, requestedProduct: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor): String? {
        return try {
            apply(applicantData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TApplicantDataImpl::class.java) }), bureauData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TBureauDataImpl::class.java) }), requestedProduct?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, type.TRequestedProductImpl::class.java) }), annotationSet_, eventListener_, externalExecutor_)
        } catch (e: Exception) {
            logError("Cannot apply decision 'Routing'", e)
            null
        }
    }

    fun apply(applicantData: type.TApplicantData?, bureauData: type.TBureauData?, requestedProduct: type.TRequestedProduct?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet): String? {
        return apply(applicantData, bureauData, requestedProduct, annotationSet_, com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor())
    }

    fun apply(applicantData: type.TApplicantData?, bureauData: type.TBureauData?, requestedProduct: type.TRequestedProduct?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor): String? {
        try {
            // Start decision 'Routing'
            val routingStartTime_ = System.currentTimeMillis()
            val routingArguments_ = com.gs.dmn.runtime.listener.Arguments()
            routingArguments_.put("applicantData", applicantData)
            routingArguments_.put("bureauData", bureauData)
            routingArguments_.put("requestedProduct", requestedProduct)
            eventListener_.startDRGElement(DRG_ELEMENT_METADATA, routingArguments_)

            // Apply child decisions
            val postBureauAffordability: Boolean? = this.postBureauAffordability.apply(applicantData, bureauData, requestedProduct, annotationSet_, eventListener_, externalExecutor_)
            val postBureauRiskCategory: String? = this.postBureauRiskCategory.apply(applicantData, bureauData, annotationSet_, eventListener_, externalExecutor_)

            // Evaluate decision 'Routing'
            val output_: String? = evaluate(bureauData, postBureauAffordability, postBureauRiskCategory, annotationSet_, eventListener_, externalExecutor_)

            // End decision 'Routing'
            eventListener_.endDRGElement(DRG_ELEMENT_METADATA, routingArguments_, output_, (System.currentTimeMillis() - routingStartTime_))

            return output_
        } catch (e: Exception) {
            logError("Exception caught in 'Routing' evaluation", e)
            return null
        }
    }

    private fun evaluate(bureauData: type.TBureauData?, postBureauAffordability: Boolean?, postBureauRiskCategory: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor): String? {
        return RoutingRules.RoutingRules(postBureauRiskCategory, postBureauAffordability, bureauData?.let({ it.bankrupt as Boolean }), bureauData?.let({ it.creditScore as java.math.BigDecimal }), annotationSet_, eventListener_, externalExecutor_) as String?
    }

    companion object {
        val DRG_ELEMENT_METADATA : com.gs.dmn.runtime.listener.DRGElement = com.gs.dmn.runtime.listener.DRGElement(
            "",
            "Routing",
            "",
            com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
            com.gs.dmn.runtime.annotation.ExpressionKind.INVOCATION,
            com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
            -1
        )
    }
}
