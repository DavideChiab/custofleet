curl -X POST "https://api-cert-preprod.groupe-psa.com/bank/financialfilemgmt/v1/mof/assetSales" \
-H "X-IBM-Client-Id: 14e1e4033a2e6097f1fde96e5a7bdbb5" \
-u "MWPWFA01:oKG4RuHf" \
--cert-type P12 \
--cert ocfweb.batch.cert.p12:P@ssw0rd \
-H "Content-Type: application/json" \
-d '{
    "financingRequest": {
        "context": {
            "requestID": "Request200",
            "senderID": "CFA",
            "countryCode": "IT",
            "requestTime": "2023-05-24T10:30:00+02:00",
            "language": "EN"
        },
        "body": {}
    }
}'
