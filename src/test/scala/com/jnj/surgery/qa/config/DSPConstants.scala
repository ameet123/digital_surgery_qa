package com.jnj.surgery.qa.config

import com.jnj.surgery.qa.util.CommonUtils

object DSPConstants {
  val PUBLIC_GW_HOST: String = "https://auth-engine.data-dev.thesurgicalnet.com"
  val GET_PATIENT_URI = "/case-create/v2/fhir/Patient/5"
  val CREATE_PATIENT_URI = "/case-create/v2/fhir/Patient"
  val CREATE_SVC_REQ_URI = "/case-create/v2/fhir/ServiceRequest"
  val HEALTH_CHEKCK_URI = "/actuator/health"
  val GET_PATIENT_URL: String = PUBLIC_GW_HOST + GET_PATIENT_URI

  // Body
  val PATIENT_CREATE_BODY: String = CommonUtils.fileToString("patient_create-1.json")
  val SVC_REQ_CREATE_BODY: String = CommonUtils.fileToString("serviceRequest_create.json")

  // HEaders
  val CONTENT_TYPE = "application/x-www-form-urlencoded"

  // Auth Headers
  val AMEET_JWT: String = "Bearer " + CommonUtils.fileToString("ameet.jwt")
  val ARYA_JWT: String = "Bearer " + CommonUtils.fileToString("arya_stark.jwt")
  val JENNY_JWT: String = "Bearer " + CommonUtils.fileToString("jenny_doe.jwt")
  val HAL_JWT: String = "Bearer " + CommonUtils.fileToString("hal_token.jwt")
  val DRHOUSE_JWT: String = "Bearer " + CommonUtils.fileToString("drhouse.jwt")
}
