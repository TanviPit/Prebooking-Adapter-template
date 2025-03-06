<#setting number_format= "0.#####################">
<#setting boolean_format="true,false">
{
"id": "<#if resultsMngo??>${(resultsMngo.id)!null}<#else>null</#if>",
"razorPayOrderId": "<#if resultsMngo??>${(resultsMngo.razorPayOrderId)!null}<#else>null</#if>",
"razorPayOrderStatus": "<#if resultsMngo??>${(resultsMngo.razorPayOrderStatus)!null}<#else>null</#if>",
"razorPayOrderMessage": "<#if resultsMngo??>${(resultsMngo.razorPayOrderMessage)!null}<#else>null</#if>",
"userId": "<#if resultsMngo??>${(resultsMngo.userId)!null}<#else>null</#if>",
"user": null,

"status": {
"code": "${(resultsTbo.status.code)!200}",
"description": "${(resultsTbo.status.description)!'Successful'}"
},

"hotelResult": [
<#if (resultsTbo.hotelResult)??>
    <#list resultsTbo.hotelResult as hotel>
        {
        "hotelCode": "${hotel.hotelCode!null}",
        "currency": "${hotel.currency!null}",
        "rooms": [
        <#if (hotel.rooms)??>
            <#list hotel.rooms as room>
                {
                "taxesAndOtherCharges": ${room.totalTax?default(0)},
                "totalAmount": ${room.totalFare?default(0)},
                "name": [<#list room.name as name>"${name}"<#if name_has_next>,</#if></#list>],
                "bookingCode": "${room.bookingCode!null}",a
                "inclusion": "${room.inclusion!null}",
                "dayRates": [
                <#if (room.dayRates)??>
                    <#list room.dayRates as dayRateList>
                        [
                        <#list dayRateList as dayRate>
                            {
                            "basePrice": "${dayRate.basePrice?number}"
                            }
                            <#if dayRate_has_next>,</#if>
                        </#list>
                        ]
                        <#if dayRateList_has_next>,</#if>
                    </#list>
                </#if>
                ],
                "totalFare": ${room.totalFare?default(0)},
                "totalTax": ${room.totalTax?default(0)},
                "netAmount": ${room.totalFare?default(0)},
                "netTax": ${room.totalTax?default(0)},
                "roomPromotion": <#if room.roomPromotion??>[<#list room.roomPromotion as promo>"${promo}"<#if promo_has_next>,</#if></#list>]<#else>null</#if>,
                "cancelPolicies": [
                <#if (room.cancelPolicies)??>
                    <#list room.cancelPolicies as policy>
                        {
                        "index": "${policy.index?default('')}",
                        "fromDate": "${policy.fromDate!null}",
                        "chargeType": "${policy.chargeType!null}",
                        "cancellationCharge": "${policy.cancellationCharge?default(0)}"
                        }
                        <#if policy_has_next>,</#if>
                    </#list>
                </#if>
                ],
                "mealType": "${room.mealType!null}",
                "supplements": <#if (room.supplements)??>${room.supplements?json_string}<#else>null</#if>,
                "isRefundable": "${room.refundable?c}",
                "withTransfers": "${room.withTransfers?c}",
                "amenities": <#if room.amenities??>[<#list room.amenities as amenity>"${amenity}"<#if amenity_has_next>,</#if></#list>]<#else>null</#if>,
                "lastCancelationDeadline": "${room.lastCancellationDeadline!''}",

                "priceBreakUp": [
                <#if (room.priceBreakUps)??>
                    <#list room.priceBreakUps as priceBreakUp>
                        {
                        "roomRate": ${priceBreakUp.roomRate?default(0)},
                        "roomTax": ${priceBreakUp.roomTax?default(0)},
                        "agentCommission": ${priceBreakUp.agentCommission?default(0)},
                        "taxBreakup": [
                        <#if priceBreakUp.taxBreakup??>
                            <#list priceBreakUp.taxBreakup as tax>
                                {
                                "taxType": "${tax.taxType}",
                                "taxableAmount": ${tax.taxableAmount?default(0)},
                                "taxPercentage": ${tax.taxPercentage?default(0)},
                                "taxAmount": ${tax.taxAmount?default(0)}
                                }
                                <#if tax_has_next>,</#if>
                            </#list>
                        <#else>
                            null
                        </#if>
                        ]
                        }
                        <#if priceBreakUp_has_next>,</#if>
                    </#list>
                </#if>
                ]
                }
                <#if room_has_next>,</#if>
            </#list>
        </#if>
        ],
        "rateConditions": <#if hotel.rateConditions??>[<#list hotel.rateConditions as condition>"${condition}"<#if condition_has_next>,</#if></#list>]<#else>null</#if>
        }
        <#if hotel_has_next>,</#if>
    </#list>
</#if>
],

"validationInfo": <#if resultsTbo.validationInfo??>
    {
    "panMandatory": ${resultsTbo.validationInfo.panMandatory?c},
    "passportMandatory": ${resultsTbo.validationInfo.passportMandatory?c},
    "corporateBookingAllowed": ${resultsTbo.validationInfo.corporateBookingAllowed?c},
    "panCountRequired": "${resultsTbo.validationInfo.panCountRequired?default(0)}",
    "samePaxNameAllowed": ${resultsTbo.validationInfo.samePaxNameAllowed?c},
    "spaceAllowed": ${resultsTbo.validationInfo.spaceAllowed?c},
    "specialCharAllowed": ${resultsTbo.validationInfo.specialCharAllowed?c},
    "paxNameMinLength": "${resultsTbo.validationInfo.paxNameMinLength?default(0)}",
    "paxNameMaxLength": "${resultsTbo.validationInfo.paxNameMaxLength?default(50)}",
    "charLimit": ${resultsTbo.validationInfo.charLimit?c},
    "packageFare": ${resultsTbo.validationInfo.packageFare?c},
    "packageDetailsMandatory": ${resultsTbo.validationInfo.packageDetailsMandatory?c},
    "departureDetailsMandatory": ${resultsTbo.validationInfo.departureDetailsMandatory?c},
    "gSTAllowed": ${resultsTbo.validationInfo.gstAllowed?c}
    }<#else>
    null
</#if>,

"bookResult": <#if resultsMngo?? && resultsMngo.bookResult??>
    {
    "voucherStatus": "<#if resultsMngo.bookResult.voucherStatus??>${resultsMngo.bookResult.voucherStatus?c}<#else>null</#if>",
    "responseStatus": "${resultsMngo.bookResult.responseStatus!0}",
    "error": <#if resultsMngo.bookResult.error??>
    {
    "errorCode": "${resultsMngo.bookResult.error.errorCode!0}",
    "errorMessage": "${resultsMngo.bookResult.error.errorMessage!null}"
    }
<#else>
    null
</#if>,
    "traceId": "${resultsMngo.bookResult.traceId!null}",
    "status": "${resultsMngo.bookResult.status!0}",
    "hotelBookingStatus": "${resultsMngo.bookResult.hotelBookingStatus!null}",
    "invoiceNumber": "${resultsMngo.bookResult.invoiceNumber!null}",
    "confirmationNo": "${resultsMngo.bookResult.confirmationNo!null}",
    "bookingRefNo": "${resultsMngo.bookResult.bookingRefNo!null}",
    "bookingId": "${resultsMngo.bookResult.bookingId!null}",
    "isPriceChanged": "<#if resultsMngo.bookResult.isPriceChanged??>${resultsMngo.bookResult.priceChanged?c}<#else>false</#if>",
    "isCancellationPolicyChanged": "<#if resultsMngo.bookResult.isCancellationPolicyChanged??>${resultsMngo.bookResult.cancellationPolicyChanged?c}<#else>false</#if>",
    "fastaysId": "<#if resultsMngo.bookResult.fastaysId??>${resultsMngo.bookResult.fastaysId}<#else>null</#if>"
    }
<#else>
    null
</#if>

}
