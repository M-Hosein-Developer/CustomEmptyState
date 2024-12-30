package ir.androidcoder.customcarddialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ir.androidcoder.customcarddialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //visibility
//        visibility()

        //text
//        setText()

        //text color
//        setTextColor()

        //font
//        setFont()


            binding.customEmptyState.setButtonAttribute(
                radius = 6,
                icon = R.drawable.ic_android_black_24dp,
                iconSize = 50,
                color = R.color.red
            )



    }

    private fun visibility() = with(binding){
//        customDialog.setDialogVisibility(true)
//        customDialog.setSuccessButtonVisibility(true)
//        customDialog.setImageAndLottieVisibility(isImageVisible = false, isLottieVisible = false)
//        customDialog.setTitleVisibility(true)
//        customDialog.setDescriptionVisibility(true)
    }

    private fun setText() = with(binding){
//        customDialog.setDialog(title = "test" , description = "test" , src = R.drawable.ic_launcher_background)
//        customDialog.setTitleAndDescription(title = "test" , description = "test")
//        customDialog.setTextButton(textButton = "test")
    }

    private fun setTextColor() = with(binding){
//        customDialog.setTitleTextColor(titleColor = R.color.black)
//        customDialog.setDescriptionTextColor(descriptionColor = R.color.black)
//        customDialog.setDescriptionColorAndTitleTextColor(color = R.color.black)
//        customDialog.textButtonColor(color = R.color.black)
    }

    private fun setFont() = with(binding){
//        customDialog.setTextFont(font = R.font.font_test_dialog)
//        customDialog.setTitleTextFont(font = R.font.font_test_dialog)
//        customDialog.setDescriptionTextFont(font = R.font.font_test_dialog)
    }

}