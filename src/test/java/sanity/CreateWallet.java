package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class CreateWallet extends CommonOps {

    @Test(description = "Test01 - Verify Create Wallet Button")
    @Description("This test checks for the Create Wallet Button ")
    public void test01_verify_createWallet() {
        Verifications.elementIsVisible(walletMain.create_wallet);
    }
}