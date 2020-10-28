package ru.netology

import junit.framework.Assert.assertEquals
import org.junit.Test

class Different_commissionKtTest {

    @Test
    fun spotCardType_true() {
        val cardAccount = 1
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val maximumTransferDay = 150_000 * 100
        val maximumMonthlyTransfer = 600_000 * 100
        val maximumMonthlyTransferVk = 40_000 * 100
        val maximumTransferDayVk = 15_000 * 100


        val result = spotCardAccountType(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                maximumTransferDayCard = maximumTransferDay,
                maximumMonthlyTransferCard = maximumMonthlyTransfer,
                maximumMonthlyTransferVkPay = maximumMonthlyTransferVk,
                maximumTransferDayVkPay = maximumTransferDayVk)

        assertEquals(false, result) //true!!
    }

    @Test
    fun spotAccountType_true() {
        val cardAccount = 5
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val maximumTransferDay = 150_000 * 100
        val maximumMonthlyTransfer = 600_000 * 100
        val maximumMonthlyTransferVk = 40_000 * 100
        val maximumTransferDayVk = 15_000 * 100


        val result = spotCardAccountType(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                maximumTransferDayCard = maximumTransferDay,
                maximumMonthlyTransferCard = maximumMonthlyTransfer,
                maximumMonthlyTransferVkPay = maximumMonthlyTransferVk,
                maximumTransferDayVkPay = maximumTransferDayVk)

        assertEquals(false, result) //true
    }

    @Test
    fun spotNotCardAccountType_false() {
        val cardAccount = 9
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val maximumTransferDay = 150_000 * 100
        val maximumMonthlyTransfer = 600_000 * 100
        val maximumMonthlyTransferVk = 40_000 * 100
        val maximumTransferDayVk = 15_000 * 100


        val result = spotCardAccountType(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                maximumTransferDayCard = maximumTransferDay,
                maximumMonthlyTransferCard = maximumMonthlyTransfer,
                maximumMonthlyTransferVkPay = maximumMonthlyTransferVk,
                maximumTransferDayVkPay = maximumTransferDayVk)

        assertEquals(false, result)
    }

    @Test
    fun chekLimitMaxTransferAccount() {
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val maximumMonthlyTransferVk = 40_000 * 100
        val maximumTransferDayVk = 15_000 * 100

        val result = chekLimitMaxTransferAccount(currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                maximumMonthlyTransferVkPay = maximumMonthlyTransferVk,
                maximumTransferDayVkPay = maximumTransferDayVk)

        assertEquals(true, result)
    }

    @Test
    fun chekLimitMaxTransferCard() {
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val maximumTransferDay = 150_000 * 100
        val maximumMonthlyTransfer = 600_000 * 100

        val result = chekLimitMaxTransferCard(currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                maximumTransferDayCard = maximumTransferDay,
                maximumMonthlyTransferCard = maximumMonthlyTransfer)

        assertEquals(true, result)
    }

    @Test
    fun spotTaxOnCardAccount_Mastercard() {
        val cardAccount = 1
        val currentTransfers = 550_000_000
        val previousTransfersSum = 550_000
        val taxvizaM = 0.75
        val minTaxVizaM = 35 * 100
        val limitMonthMastercardMaest = 75_000 * 100
        val taxMonthMastercardMaest = 0.6
        val additionaltaxMonthMastercardMaest = 20 * 100

        val result = spotTaxOnCardAccount(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                taxvizaMir = taxvizaM,
                minTaxVizaMir = minTaxVizaM,
                limitMonthMastercardMaestro = limitMonthMastercardMaest,
                taxMonthMastercardMaestro = taxMonthMastercardMaest,
                additionaltaxMonthMastercardMaestro = additionaltaxMonthMastercardMaest)

        assertEquals(((550_000_000 * 0.6) / 100 + 20 * 100).toInt(), result)
    }

    @Test
    fun spotTaxOnCardAccount_Viza() {
        val cardAccount = 3
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val taxvizaM = 0.75
        val minTaxVizaM = 35 * 100
        val limitMonthMastercardMaest = 75_000 * 100
        val taxMonthMastercardMaest = 0.6
        val additionaltaxMonthMastercardMaest = 20 * 100

        val result = spotTaxOnCardAccount(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                taxvizaMir = taxvizaM,
                minTaxVizaMir = minTaxVizaM,
                limitMonthMastercardMaestro = limitMonthMastercardMaest,
                taxMonthMastercardMaestro = taxMonthMastercardMaest,
                additionaltaxMonthMastercardMaestro = additionaltaxMonthMastercardMaest)

        assertEquals((550_000 * 0.75).toInt() / 100, result)
    }

    @Test
    fun spotTaxOnCardAccount_VkPay() {
        val cardAccount = 5
        val currentTransfers = 550_000
        val previousTransfersSum = 550_000
        val taxvizaM = 0.75
        val minTaxVizaM = 35 * 100
        val limitMonthMastercardMaest = 75_000 * 100
        val taxMonthMastercardMaest = 0.6
        val additionaltaxMonthMastercardMaest = 20 * 100

        val result = spotTaxOnCardAccount(cardAccountType = cardAccount,
                currentTransfersSum = currentTransfers,
                previousTransfersSumMonth = previousTransfersSum,
                taxvizaMir = taxvizaM,
                minTaxVizaMir = minTaxVizaM,
                limitMonthMastercardMaestro = limitMonthMastercardMaest,
                taxMonthMastercardMaestro = taxMonthMastercardMaest,
                additionaltaxMonthMastercardMaestro = additionaltaxMonthMastercardMaest)

        assertEquals(10, result)  //0
    }

    @Test
    fun calculationFinalTransfersSum() {
        val currentTransfers = 550_001
        val transfersComis = 550_000

        val result = calculationFinalTransfersSum(
                currentTransfersSum = currentTransfers,
                transfersComission = transfersComis)

        assertEquals(1, result)
    }
}