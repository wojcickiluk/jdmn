
import java.util.*
import java.util.stream.Collectors

@javax.annotation.Generated(value = ["decision.ftl", "Eligibility"])
@com.gs.dmn.runtime.annotation.DRGElement(
    namespace = "",
    name = "Eligibility",
    label = "",
    elementKind = com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
    expressionKind = com.gs.dmn.runtime.annotation.ExpressionKind.INVOCATION,
    hitPolicy = com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
    rulesCount = -1
)
class Eligibility(val preBureauAffordability : PreBureauAffordability = PreBureauAffordability(), val preBureauRiskCategory : PreBureauRiskCategory = PreBureauRiskCategory()) : com.gs.dmn.runtime.DefaultDMNBaseDecision() {
    fun apply(applicantData: String?, requestedProduct: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet): String? {
        return try {
            apply(applicantData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, object : com.fasterxml.jackson.core.type.TypeReference<type.TApplicantDataImpl>() {}) }), requestedProduct?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, object : com.fasterxml.jackson.core.type.TypeReference<type.TRequestedProductImpl>() {}) }), annotationSet_, com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor(), com.gs.dmn.runtime.cache.DefaultCache())
        } catch (e: Exception) {
            logError("Cannot apply decision 'Eligibility'", e)
            null
        }
    }

    fun apply(applicantData: String?, requestedProduct: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor, cache_: com.gs.dmn.runtime.cache.Cache): String? {
        return try {
            apply(applicantData?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, object : com.fasterxml.jackson.core.type.TypeReference<type.TApplicantDataImpl>() {}) }), requestedProduct?.let({ com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(it, object : com.fasterxml.jackson.core.type.TypeReference<type.TRequestedProductImpl>() {}) }), annotationSet_, eventListener_, externalExecutor_, cache_)
        } catch (e: Exception) {
            logError("Cannot apply decision 'Eligibility'", e)
            null
        }
    }

    fun apply(applicantData: type.TApplicantData?, requestedProduct: type.TRequestedProduct?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet): String? {
        return apply(applicantData, requestedProduct, annotationSet_, com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor(), com.gs.dmn.runtime.cache.DefaultCache())
    }

    fun apply(applicantData: type.TApplicantData?, requestedProduct: type.TRequestedProduct?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor, cache_: com.gs.dmn.runtime.cache.Cache): String? {
        try {
            // Start decision 'Eligibility'
            val eligibilityStartTime_ = System.currentTimeMillis()
            val eligibilityArguments_ = com.gs.dmn.runtime.listener.Arguments()
            eligibilityArguments_.put("ApplicantData", applicantData)
            eligibilityArguments_.put("RequestedProduct", requestedProduct)
            eventListener_.startDRGElement(DRG_ELEMENT_METADATA, eligibilityArguments_)

            // Apply child decisions
            val preBureauAffordability: Boolean? = this.preBureauAffordability.apply(applicantData, requestedProduct, annotationSet_, eventListener_, externalExecutor_, cache_)
            val preBureauRiskCategory: String? = this.preBureauRiskCategory.apply(applicantData, annotationSet_, eventListener_, externalExecutor_, cache_)

            // Evaluate decision 'Eligibility'
            val output_: String? = evaluate(applicantData, preBureauAffordability, preBureauRiskCategory, annotationSet_, eventListener_, externalExecutor_, cache_)

            // End decision 'Eligibility'
            eventListener_.endDRGElement(DRG_ELEMENT_METADATA, eligibilityArguments_, output_, (System.currentTimeMillis() - eligibilityStartTime_))

            return output_
        } catch (e: Exception) {
            logError("Exception caught in 'Eligibility' evaluation", e)
            return null
        }
    }

    fun apply(eligibilityRequest_: proto.EligibilityRequest, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet): proto.EligibilityResponse {
        return apply(eligibilityRequest_, annotationSet_, com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor(), com.gs.dmn.runtime.cache.DefaultCache())
    }

    fun apply(eligibilityRequest_: proto.EligibilityRequest, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor, cache_: com.gs.dmn.runtime.cache.Cache): proto.EligibilityResponse {
        // Create arguments from Request Message
        var applicantData: type.TApplicantData? = type.TApplicantData.toTApplicantData(eligibilityRequest_.getApplicantData())
        var requestedProduct: type.TRequestedProduct? = type.TRequestedProduct.toTRequestedProduct(eligibilityRequest_.getRequestedProduct())
        
        // Invoke apply method
        var output_: String? = apply(applicantData, requestedProduct, annotationSet_, eventListener_, externalExecutor_, cache_)
        
        // Convert output to Response Message
        var builder_: proto.EligibilityResponse.Builder = proto.EligibilityResponse.newBuilder()
        builder_.setEligibility((if (output_ == null) null else output_!!))
        return builder_.build()
    }

    private inline fun evaluate(applicantData: type.TApplicantData?, preBureauAffordability: Boolean?, preBureauRiskCategory: String?, annotationSet_: com.gs.dmn.runtime.annotation.AnnotationSet, eventListener_: com.gs.dmn.runtime.listener.EventListener, externalExecutor_: com.gs.dmn.runtime.external.ExternalFunctionExecutor, cache_: com.gs.dmn.runtime.cache.Cache): String? {
        return EligibilityRules.EligibilityRules(preBureauRiskCategory, preBureauAffordability, applicantData?.let({ it.age as java.math.BigDecimal? }), annotationSet_, eventListener_, externalExecutor_, cache_) as String?
    }

    companion object {
        val DRG_ELEMENT_METADATA : com.gs.dmn.runtime.listener.DRGElement = com.gs.dmn.runtime.listener.DRGElement(
            "",
            "Eligibility",
            "",
            com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
            com.gs.dmn.runtime.annotation.ExpressionKind.INVOCATION,
            com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
            -1
        )

        @JvmStatic
        fun requestToMap(eligibilityRequest_: proto.EligibilityRequest): kotlin.collections.Map<String, Any?> {
            // Create arguments from Request Message
            var applicantData: type.TApplicantData? = type.TApplicantData.toTApplicantData(eligibilityRequest_.getApplicantData())
            var requestedProduct: type.TRequestedProduct? = type.TRequestedProduct.toTRequestedProduct(eligibilityRequest_.getRequestedProduct())
            
            // Create map
            var map_: kotlin.collections.MutableMap<String, Any?> = mutableMapOf()
            map_.put("ApplicantData", applicantData)
            map_.put("RequestedProduct", requestedProduct)
            return map_
        }

        @JvmStatic
        fun responseToOutput(eligibilityResponse_: proto.EligibilityResponse): String? {
            // Extract and convert output
            return eligibilityResponse_.getEligibility()
        }
    }
}
