package ir.androidcoder.customdialog

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.BLACK
import android.graphics.Color.TRANSPARENT
import android.graphics.Color.WHITE
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.RawRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.google.android.material.button.MaterialButton
import ir.androidcoder.customdialog.databinding.AndroidcoderEmptyStateBinding

class CustomEmptyState @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CardView(context , attrs) {

    private var binding = AndroidcoderEmptyStateBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        initializeDialog(attrs)
    }

    @SuppressLint("NewApi")
    private fun initializeDialog(attrs: AttributeSet?) = with(binding) {

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomDialog, 0, 0)


            //text
            txtEmptyStateTitle.text = typedArray.getString(R.styleable.CustomDialog_titleText) ?: "Default Title"
            txtEmptyStateDesc.text = typedArray.getString(R.styleable.CustomDialog_descText) ?: "Default Title"
            btnEmptyStateSuccess.text = typedArray.getString(R.styleable.CustomDialog_btnSuccessText) ?: "Default Title"

            //single and max line
            txtEmptyStateTitle.isSingleLine = typedArray.getBoolean(R.styleable.CustomDialog_titleSingleLine, false)
            txtEmptyStateDesc.isSingleLine = typedArray.getBoolean(R.styleable.CustomDialog_descSingleLine, false)
            txtEmptyStateTitle.maxLines = typedArray.getInt(R.styleable.CustomDialog_titleMaxLine, 100)
            txtEmptyStateDesc.maxLines = typedArray.getInt(R.styleable.CustomDialog_descMaxLine, 100)

            //text style
/*            txtDialogTitle.setTypeface(null , when(typedArray.getInt(R.styleable.CustomDialog_titleTextStyle , 0)){
                0 -> Typeface.NORMAL
                1 -> Typeface.BOLD
                2 -> Typeface.ITALIC
                3 -> Typeface.BOLD_ITALIC
                else -> Typeface.NORMAL
            })

            txtDialogDesc.setTypeface(null , when(typedArray.getInt(R.styleable.CustomDialog_descriptionTextStyle , 0)){
                0 -> Typeface.NORMAL
                1 -> Typeface.BOLD
                2 -> Typeface.ITALIC
                3 -> Typeface.BOLD_ITALIC
                else -> Typeface.NORMAL
            })

            btnSuccess.setTypeface(null , when(typedArray.getInt(R.styleable.CustomDialog_btnTextStyle , 0)){
                0 -> Typeface.NORMAL
                1 -> Typeface.BOLD
                2 -> Typeface.ITALIC
                3 -> Typeface.BOLD_ITALIC
                else -> Typeface.NORMAL
            })

 */

            //text color
            txtEmptyStateTitle.setTextColor(
                typedArray.getColor(
                    R.styleable.CustomDialog_titleTextColor,
                    BLACK
                )
            )

            txtEmptyStateDesc.setTextColor(
                typedArray.getColor(
                    R.styleable.CustomDialog_descTextColor,
                    BLACK
                )
            )

            btnEmptyStateSuccess.setTextColor(
                typedArray.getColor(
                    R.styleable.CustomDialog_descTextColor,
                    WHITE
                )
            )


            //text size
            txtEmptyStateTitle.textSize = typedArray.getDimension(R.styleable.CustomDialog_titleTextSize, 16f)
            txtEmptyStateDesc.textSize = typedArray.getDimension(R.styleable.CustomDialog_descTextSize, 14f)
            btnEmptyStateSuccess.textSize = typedArray.getDimension(R.styleable.CustomDialog_descTextSize, 16f)


            //card view
            mainEmptyState.radius = typedArray.getDimension(R.styleable.CustomDialog_cardRadius, 12f)
            mainEmptyState.cardElevation = typedArray.getDimension(R.styleable.CustomDialog_cardElevation, 4f)
            mainEmptyState.setCardBackgroundColor(typedArray.getColor(R.styleable.CustomDialog_cardBackgroundColor, WHITE))


            //padding
            txtEmptyStateTitle.setPadding(typedArray.getDimension(R.styleable.CustomDialog_titlePadding , 0f).toInt())
            txtEmptyStateDesc.setPadding(typedArray.getDimension(R.styleable.CustomDialog_descPadding , 0f).toInt())
//            btnEmptyStateSuccess.setPadding(typedArray.getDimension(R.styleable.CustomDialog_btnSuccessPadding , 0f).toInt())
//            btnEmptyStateSuccess.setPadding(typedArray.getDimension(R.styleable.CustomDialog_btnSuccessEndPadding , 0f).toInt())
            imgEmptyState.setPadding(typedArray.getDimension(R.styleable.CustomDialog_imgPadding , 0f).toInt())

            //font
            txtEmptyStateTitle.typeface = typedArray.getFont(R.styleable.CustomDialog_fontFamily)
            txtEmptyStateDesc.typeface = typedArray.getFont(R.styleable.CustomDialog_fontFamily)
            btnEmptyStateSuccess.typeface = typedArray.getFont(R.styleable.CustomDialog_fontFamily)


            //set image
            imgEmptyState.setImageResource(
                typedArray.getResourceId(
                    R.styleable.CustomDialog_src,
                    R.drawable.success
                )
            )


            //visibility
            btnEmptyStateSuccess.visibility =
                when (typedArray.getInt(R.styleable.CustomDialog_btnSuccessVisibility, 0)) {
                    0 -> View.VISIBLE
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                }

            txtEmptyStateTitle.visibility =
                when (typedArray.getInt(R.styleable.CustomDialog_txtTitleVisibility, 0)) {
                    0 -> View.VISIBLE
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                }

            txtEmptyStateDesc.visibility =
                when (typedArray.getInt(R.styleable.CustomDialog_txtDescriptionVisibility, 0)) {
                    0 -> View.VISIBLE
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                }

            imgEmptyState.visibility =
                when (typedArray.getInt(R.styleable.CustomDialog_imgVisibility, 0)) {
                    0 -> View.VISIBLE
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                }

            mainEmptyState.visibility =
                when (typedArray.getInt(R.styleable.CustomDialog_mainCustomEmptyStateVisibility, 0)) {
                    0 -> View.VISIBLE
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                }


            //background src
            btnEmptyStateSuccess.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomDialog_btnSuccessBackground , TRANSPARENT))
            mainEmptyState.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomDialog_mainCustomDialogBackground , 0))
            txtEmptyStateTitle.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomDialog_txtTitleBackground , 0))
            txtEmptyStateDesc.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomDialog_txtDescriptionBackground , 0))


            //lottie
            lottieAnimation.setAnimation(typedArray.getInt(R.styleable.CustomDialog_rawRes_animation , R.raw.error))
            lottieAnimation.loop(typedArray.getBoolean(R.styleable.CustomDialog_loop_animation , true))
            lottieAnimation.playAnimation()
            lottieAnimation.visibility = if (typedArray.getInt(R.styleable.CustomDialog_lottieVisibility , 0) == 0) View.VISIBLE else View.GONE

            //button
            btnEmptyStateSuccess.cornerRadius = typedArray.getDimension(R.styleable.CustomDialog_buttonCornerRadius , 0f).toInt()
            btnEmptyStateSuccess.setIconResource(typedArray.getResourceId(R.styleable.CustomDialog_setIconButton , 0))
            btnEmptyStateSuccess.iconGravity = typedArray.getInt(R.styleable.CustomDialog_setIconButtonGravity , 0)
            btnEmptyStateSuccess.iconSize = typedArray.getDimension(R.styleable.CustomDialog_iconButtonSize , 0f).toInt()


            typedArray.recycle()

        }
    }

    //visibility------------------------------------------------------------------------------------
    fun setDialogVisibility(isVisible: Boolean) = with(binding){
        mainEmptyState.visibility = if (isVisible) View.VISIBLE else View.GONE
    }//tested

    fun setSuccessButtonVisibility(isVisible: Boolean) = with(binding){
        btnEmptyStateSuccess.visibility = if (isVisible) View.VISIBLE else View.GONE
    }//tested

    fun setImageAndLottieVisibility(isImageVisible: Boolean , isLottieVisible: Boolean) = with(binding){
        imgEmptyState.visibility = if (isImageVisible) View.VISIBLE else View.INVISIBLE
        lottieAnimation.visibility = if (isLottieVisible) View.VISIBLE else View.GONE
    }//tested

    fun setTitleVisibility(isVisible: Boolean) = with(binding){
        txtEmptyStateTitle.visibility = if (isVisible) View.VISIBLE else View.GONE
    }//tested

    fun setDescriptionVisibility(isVisible: Boolean) = with(binding){
        txtEmptyStateDesc.visibility = if (isVisible) View.VISIBLE else View.GONE
    }//tested


    //text------------------------------------------------------------------------------------------
    fun setDialog(title: String , description: String , src : Int) = with(binding){
        lottieAnimation.visibility = View.GONE
        imgEmptyState.visibility = View.VISIBLE
        imgEmptyState.setImageResource(src)
        txtEmptyStateTitle.text = title
        txtEmptyStateDesc.text = description
    }//tested

    fun setTitleAndDescription(title: String , description: String) = with(binding){
        txtEmptyStateTitle.text = title
        txtEmptyStateDesc.text = description
    }//tested


    //single and max line---------------------------------------------------------------------------
    fun setTitleSingleLine(singleLine : Boolean) = with(binding){
        txtEmptyStateTitle.isSingleLine = singleLine
        txtEmptyStateTitle.ellipsize = if (singleLine) TextUtils.TruncateAt.END else null
    }//tested

    fun setDescriptionSingleLine(singleLine : Boolean) = with(binding){
        txtEmptyStateDesc.isSingleLine = singleLine
        txtEmptyStateDesc.ellipsize = if (singleLine) TextUtils.TruncateAt.END else null
    }//tested

    fun setTitleMaxLine(maxLine : Int) = with(binding){
        txtEmptyStateTitle.maxLines = maxLine
    }//tested

    fun setDescriptionMaxLine(maxLine : Int) = with(binding){
        txtEmptyStateDesc.maxLines = maxLine
    }//tested


    //button text-----------------------------------------------------------------------------------
    fun setTextButton(textButton : String) = with(binding){
        btnEmptyStateSuccess.text = textButton
    }//tested

    fun setCornerButton(radius : Int) = with(binding){
        btnEmptyStateSuccess.cornerRadius = radius
    }//not work

    fun setButtonIcon(icon : Int) = with(binding){
        btnEmptyStateSuccess.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_END
        btnEmptyStateSuccess.setIconResource(icon)
    }//tested

    //color-----------------------------------------------------------------------------------------
    fun setTitleTextColor(@ColorRes titleColor : Int) = with(binding){
        val color = ContextCompat.getColor(root.context, titleColor)
        txtEmptyStateTitle.setTextColor(color)
    }//tested

    fun setDescriptionTextColor(@ColorRes descriptionColor : Int) = with(binding){
        val color = ContextCompat.getColor(root.context, descriptionColor)
        txtEmptyStateDesc.setTextColor(color)
    }//tested

    fun setDescriptionColorAndTitleTextColor(@ColorRes color : Int) = with(binding) {
        val allColor = ContextCompat.getColor(root.context, color)
        txtEmptyStateTitle.setTextColor(allColor)
        txtEmptyStateDesc.setTextColor(allColor)
    }//tested

    fun textButtonColor(@ColorRes color : Int) = with(binding){
        val buttonTextColor = ContextCompat.getColor(root.context, color)
        btnEmptyStateSuccess.setTextColor(buttonTextColor)
    }//tested


    //font------------------------------------------------------------------------------------------
    fun setTextFont(font: Int) = with(binding){
        txtEmptyStateTitle.typeface = ResourcesCompat.getFont(context , font)
        txtEmptyStateDesc.typeface = ResourcesCompat.getFont(context , font)
        btnEmptyStateSuccess.typeface = ResourcesCompat.getFont(context , font)
    }//tested

    fun setTitleTextFont(font: Int) = with(binding){
        txtEmptyStateTitle.typeface = ResourcesCompat.getFont(context , font)
    }//tested

    fun setDescriptionTextFont(font: Int) = with(binding){
        txtEmptyStateDesc.typeface = ResourcesCompat.getFont(context , font)
    }//tested

    fun setButtonTextFont(font: Int) = with(binding){
        btnEmptyStateSuccess.typeface = ResourcesCompat.getFont(context , font)
    }//tested


    //text size-------------------------------------------------------------------------------------
    fun setTextSize(titleSize : Float = 14f , descriptionSize : Float = 12f , buttonSize : Float = 14f) = with(binding){
        txtEmptyStateTitle.textSize = titleSize
        txtEmptyStateDesc.textSize = descriptionSize
        btnEmptyStateSuccess.textSize = buttonSize
    }//tested


    //padding---------------------------------------------------------------------------------------
    fun setPaddingView(titlePadding : Int = 0 , descriptionPadding : Int = 0 , buttonPadding : Int = 0 , imagePadding : Int = 0 , lottiePadding : Int = 0) = with(binding){
        txtEmptyStateTitle.setPadding(titlePadding)
        txtEmptyStateDesc.setPadding(descriptionPadding)
        btnEmptyStateSuccess.setPadding(buttonPadding)
        imgEmptyState.setPadding(imagePadding)
        lottieAnimation.setPadding(lottiePadding)
    }//tested


    //style-----------------------------------------------------------------------------------------
    /**
     * @param titleStyle 0 -> normal , 1 -> bold , 2 -> italic
     */
    fun setTextStyle(titleStyle : Int = 0 , descriptionStyle : Int = 0 , buttonStyle : Int = 0) = with(binding){
        txtEmptyStateTitle.setTypeface(null , when(titleStyle) {
            0 -> Typeface.NORMAL
            1 -> Typeface.BOLD
            2 -> Typeface.ITALIC
            else -> Typeface.NORMAL
        })

        txtEmptyStateDesc.setTypeface(null , when(descriptionStyle) {
            0 -> Typeface.NORMAL
            1 -> Typeface.BOLD
            2 -> Typeface.ITALIC
            else -> Typeface.NORMAL
        })

        btnEmptyStateSuccess.setTypeface(null , when(buttonStyle) {
            0 -> Typeface.NORMAL
            1 -> Typeface.BOLD
            2 -> Typeface.ITALIC
            else -> Typeface.NORMAL
        })
    }//tested

    //background --------------------------------------------------------------------------------
    fun setButtonBackground(background : Int) = with(binding){
        btnEmptyStateSuccess.setBackgroundResource(background)
    }//tested

    fun setTitleBackground(background : Int) = with(binding){
        txtEmptyStateTitle.setBackgroundResource(background)
    }//tested

    fun setDescriptionBackground(background : Int) = with(binding){
        txtEmptyStateDesc.setBackgroundResource(background)
    }//tested

    fun setMainBackground(@ColorRes background : Int) = with(binding){
        mainEmptyState.setBackgroundResource(background)
    }//tested

    fun setOnOkClickListener(onClick:(View) -> Unit) = with(binding){
        btnEmptyStateSuccess.setOnClickListener {
            onClick(it)
        }
    }//tested


    //lottie
    fun setupLottieAnimation(@RawRes rawRes : Int, loop : Boolean = true, padding : Int = 0) = with(binding){
        imgEmptyState.visibility = View.INVISIBLE
        lottieAnimation.visibility = View.VISIBLE
        lottieAnimation.setAnimation(rawRes)
        lottieAnimation.playAnimation()
        lottieAnimation.loop(loop)
        lottieAnimation.setPadding(padding)
    }//tested


    //button
    fun setButtonAttribute(radius: Int , icon: Int , iconSize : Int , color : Int) = with(binding){
        btnEmptyStateSuccess.cornerRadius = 22
        btnEmptyStateSuccess.icon = ContextCompat.getDrawable(context , icon)
        btnEmptyStateSuccess.iconSize = iconSize
        btnEmptyStateSuccess.setIconTintResource(color)
    }//not work

}