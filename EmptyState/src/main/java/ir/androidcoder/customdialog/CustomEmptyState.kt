package ir.androidcoder.customdialog

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Color.BLACK
import android.graphics.Color.TRANSPARENT
import android.graphics.Color.WHITE
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.AnyRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getDimensionPixelSizeOrThrow
import androidx.core.content.res.getIntOrThrow
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

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomEmptyState,
            0,
            0
        ).apply {
            attrs?.let {
                val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomEmptyState, 0, 0)


                //text
                txtEmptyStateTitle.text = typedArray.getString(R.styleable.CustomEmptyState_es_titleText) ?: "Default Title"
                txtEmptyStateDesc.text = typedArray.getString(R.styleable.CustomEmptyState_es_descText) ?: "Default Title"
                btnEmptyStateSuccess.text = typedArray.getString(R.styleable.CustomEmptyState_es_btnOkText) ?: "Default Title"

                //single and max line
                txtEmptyStateTitle.isSingleLine = typedArray.getBoolean(R.styleable.CustomEmptyState_es_titleSingleLine, false)
                txtEmptyStateDesc.isSingleLine = typedArray.getBoolean(R.styleable.CustomEmptyState_es_descSingleLine, false)
                txtEmptyStateTitle.maxLines = typedArray.getInt(R.styleable.CustomEmptyState_es_titleMaxLine, 100)
                txtEmptyStateDesc.maxLines = typedArray.getInt(R.styleable.CustomEmptyState_es_descMaxLine, 100)

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
                        R.styleable.CustomEmptyState_es_titleTextColor,
                        BLACK
                    )
                )

                txtEmptyStateDesc.setTextColor(
                    typedArray.getColor(
                        R.styleable.CustomEmptyState_es_descTextColor,
                        BLACK
                    )
                )

                btnEmptyStateSuccess.setTextColor(
                    typedArray.getColor(
                        R.styleable.CustomEmptyState_es_descTextColor,
                        WHITE
                    )
                )


                //text size
                txtEmptyStateTitle.textSize = typedArray.getDimension(R.styleable.CustomEmptyState_es_titleTextSize, 16f)
                txtEmptyStateDesc.textSize = typedArray.getDimension(R.styleable.CustomEmptyState_es_descTextSize, 14f)
                btnEmptyStateSuccess.textSize = typedArray.getDimension(R.styleable.CustomEmptyState_es_descTextSize, 16f)


                //card view
//            mainEmptyState.radius = typedArray.getDimension(R.styleable.CustomDialog_es_cardRadius , 34f)
//            mainEmptyState.cardElevation = typedArray.getDimension(R.styleable.CustomDialog_es_cardElevation, 4f)
//            mainEmptyState.setCardBackgroundColor(typedArray.getColor(R.styleable.CustomDialog_es_cardBackgroundColor, WHITE))


                //padding
                txtEmptyStateTitle.setPadding(typedArray.getDimension(R.styleable.CustomEmptyState_es_titlePadding , 0f).toInt())
                txtEmptyStateDesc.setPadding(typedArray.getDimension(R.styleable.CustomEmptyState_es_descPadding , 0f).toInt())
//            btnEmptyStateSuccess.setPadding(typedArray.getDimension(R.styleable.CustomDialog_btnSuccessPadding , 0f).toInt())
//            btnEmptyStateSuccess.setPadding(typedArray.getDimension(R.styleable.CustomDialog_btnSuccessEndPadding , 0f).toInt())
                imgEmptyState.setPadding(typedArray.getDimension(R.styleable.CustomEmptyState_es_imgPadding , 0f).toInt())

                //font
                txtEmptyStateTitle.typeface = typedArray.getFont(R.styleable.CustomEmptyState_es_fontFamily)
                txtEmptyStateDesc.typeface = typedArray.getFont(R.styleable.CustomEmptyState_es_fontFamily)
                btnEmptyStateSuccess.typeface = typedArray.getFont(R.styleable.CustomEmptyState_es_fontFamily)


                //set image
                imgEmptyState.setImageResource(
                    typedArray.getResourceId(
                        R.styleable.CustomEmptyState_es_src,
                        R.drawable.success
                    )
                )


                //visibility
                btnEmptyStateSuccess.visibility =
                    when (typedArray.getInt(R.styleable.CustomEmptyState_es_btnOkVisibility, 0)) {
                        0 -> View.VISIBLE
                        1 -> View.INVISIBLE
                        2 -> View.GONE
                        else -> View.VISIBLE
                    }

                txtEmptyStateTitle.visibility =
                    when (typedArray.getInt(R.styleable.CustomEmptyState_es_txtTitleVisibility, 0)) {
                        0 -> View.VISIBLE
                        1 -> View.INVISIBLE
                        2 -> View.GONE
                        else -> View.VISIBLE
                    }

                txtEmptyStateDesc.visibility =
                    when (typedArray.getInt(R.styleable.CustomEmptyState_es_txtDescriptionVisibility, 0)) {
                        0 -> View.VISIBLE
                        1 -> View.INVISIBLE
                        2 -> View.GONE
                        else -> View.VISIBLE
                    }

                imgEmptyState.visibility =
                    when (typedArray.getInt(R.styleable.CustomEmptyState_es_imgVisibility, 0)) {
                        0 -> View.VISIBLE
                        1 -> View.INVISIBLE
                        2 -> View.GONE
                        else -> View.VISIBLE
                    }

                mainEmptyState.visibility =
                    when (typedArray.getInt(R.styleable.CustomEmptyState_es_mainCustomEmptyStateVisibility, 0)) {
                        0 -> View.VISIBLE
                        1 -> View.INVISIBLE
                        2 -> View.GONE
                        else -> View.VISIBLE
                    }


                //background src
//                btnEmptyStateSuccess.background = typedArray.getDrawable(R.styleable.CustomEmptyState_es_btnOkBackground)
                btnEmptyStateSuccess.setBackgroundColor(typedArray.getInt(R.styleable.CustomEmptyState_es_btnOkBackground , R.color.blue))
                mainEmptyState.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomEmptyState_es_mainCustomDialogBackground , 0))
                txtEmptyStateTitle.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomEmptyState_es_txtTitleBackground , 0))
                txtEmptyStateDesc.setBackgroundResource(typedArray.getResourceId(R.styleable.CustomEmptyState_es_txtDescriptionBackground , 0))


                //lottie
                lottieAnimation.setAnimation(typedArray.getInt(R.styleable.CustomEmptyState_es_rawRes_animation , R.raw.error))
                lottieAnimation.loop(typedArray.getBoolean(R.styleable.CustomEmptyState_es_loop_animation , true))
                lottieAnimation.playAnimation()
                lottieAnimation.visibility = if (typedArray.getInt(R.styleable.CustomEmptyState_es_lottieVisibility , 0) == 0) View.VISIBLE else View.GONE

                //button
                btnEmptyStateSuccess.cornerRadius = typedArray.getDimension(R.styleable.CustomEmptyState_es_btnCornerRadius , 0f).toInt()
                btnEmptyStateSuccess.setIconResource(typedArray.getResourceId(R.styleable.CustomEmptyState_es_setIconButton , 0))
                btnEmptyStateSuccess.iconGravity = typedArray.getInt(R.styleable.CustomEmptyState_es_setIconButtonGravity , 0)
                btnEmptyStateSuccess.iconSize = typedArray.getDimension(R.styleable.CustomEmptyState_es_iconButtonSize , 0f).toInt()


                typedArray.recycle()

            }

        }
    }

    //visibility------------------------------------------------------------------------------------
    fun setEmptyStateVisibility(isVisible: Boolean) : CustomEmptyState{
        with(binding){
            mainEmptyState.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        return this
    }//tested

    fun setOkButtonVisibility(isVisible: Boolean) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        return this
    }//tested

    fun setImageAndLottieVisibility(isImageVisible: Boolean , isLottieVisible: Boolean) : CustomEmptyState{
        with(binding){
            imgEmptyState.visibility = if (isImageVisible) View.VISIBLE else View.INVISIBLE
            lottieAnimation.visibility = if (isLottieVisible) View.VISIBLE else View.GONE
        }
        return this
    }//tested

    fun setTitleVisibility(isVisible: Boolean) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        return this
    }//tested

    fun setDescriptionVisibility(isVisible: Boolean) : CustomEmptyState{
        with(binding){
            txtEmptyStateDesc.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        return this
    }//tested


    //text------------------------------------------------------------------------------------------
    fun setEmptyState(title: String , description: String , src : Int) : CustomEmptyState{
        with(binding){
            lottieAnimation.visibility = View.GONE
            imgEmptyState.visibility = View.VISIBLE
            imgEmptyState.setImageResource(src)
            txtEmptyStateTitle.text = title
            txtEmptyStateDesc.text = description
        }
        return this
    }//tested

    fun setTitleAndDescription(title: String , description: String) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.text = title
            txtEmptyStateDesc.text = description
        }
        return this
    }//tested


    //single and max line---------------------------------------------------------------------------
    fun setTitleSingleLine(singleLine : Boolean) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.isSingleLine = singleLine
            txtEmptyStateTitle.ellipsize = if (singleLine) TextUtils.TruncateAt.END else null
        }
        return this
    }//tested

    fun setDescriptionSingleLine(singleLine : Boolean) : CustomEmptyState{
        with(binding){
            txtEmptyStateDesc.isSingleLine = singleLine
            txtEmptyStateDesc.ellipsize = if (singleLine) TextUtils.TruncateAt.END else null
        }
        return this
    }//tested

    fun setTitleMaxLine(maxLine : Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.maxLines = maxLine
        }
        return this
    }//tested

    fun setDescriptionMaxLine(maxLine : Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateDesc.maxLines = maxLine
        }
        return this
    }//tested


    //button text-----------------------------------------------------------------------------------
    fun setTextButton(textButton : String) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.text = textButton
        }
        return this
    }//tested

    fun setCornerButton(radius : Int = 12) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.cornerRadius = radius
        }
        return this
    }//not work

    fun setButtonIcon(icon : Int) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_END
            btnEmptyStateSuccess.setIconResource(icon)
        }
        return this
    }//tested


    //color-----------------------------------------------------------------------------------------
    fun setTitleTextColor(@ColorRes titleColor : Int) : CustomEmptyState{
        with(binding){
            val color = ContextCompat.getColor(root.context, titleColor)
            txtEmptyStateTitle.setTextColor(color)
        }
        return this
    }//tested

    fun setDescriptionTextColor(@ColorRes descriptionColor : Int) : CustomEmptyState{
        with(binding){
            val color = ContextCompat.getColor(root.context, descriptionColor)
            txtEmptyStateDesc.setTextColor(color)
        }
        return this
    }//tested

    fun setDescriptionColorAndTitleTextColor(@ColorRes color : Int) : CustomEmptyState{
        with(binding) {
            val allColor = ContextCompat.getColor(root.context, color)
            txtEmptyStateTitle.setTextColor(allColor)
            txtEmptyStateDesc.setTextColor(allColor)
        }
        return this
    }//tested

    fun setTextButtonColor(@ColorRes color : Int) : CustomEmptyState{
        with(binding){
            val buttonTextColor = ContextCompat.getColor(root.context, color)
            btnEmptyStateSuccess.setTextColor(buttonTextColor)
        }
        return this
    }//tested


    //font------------------------------------------------------------------------------------------
    fun setTextFont(font: Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.typeface = ResourcesCompat.getFont(context , font)
            txtEmptyStateDesc.typeface = ResourcesCompat.getFont(context , font)
            btnEmptyStateSuccess.typeface = ResourcesCompat.getFont(context , font)
        }
        return this
    }//tested

    fun setTitleTextFont(font: Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.typeface = ResourcesCompat.getFont(context , font)
        }
        return this
    }//tested

    fun setDescriptionTextFont(font: Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateDesc.typeface = ResourcesCompat.getFont(context , font)
        }
        return this
    }//tested

    fun setButtonTextFont(font: Int) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.typeface = ResourcesCompat.getFont(context , font)
        }
        return this
    }//tested


    //text size-------------------------------------------------------------------------------------
    fun setTextSize(titleSize : Float = 14f , descriptionSize : Float = 12f , buttonSize : Float = 14f) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.textSize = titleSize
            txtEmptyStateDesc.textSize = descriptionSize
            btnEmptyStateSuccess.textSize = buttonSize
        }
        return this
    }//tested


    //padding---------------------------------------------------------------------------------------
    fun setPaddingView(titlePadding : Int = 0 , descriptionPadding : Int = 0 , buttonPadding : Int = 0 , imagePadding : Int = 0 , lottiePadding : Int = 0) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.setPadding(titlePadding)
            txtEmptyStateDesc.setPadding(descriptionPadding)
            btnEmptyStateSuccess.setPadding(buttonPadding)
            imgEmptyState.setPadding(imagePadding)
            lottieAnimation.setPadding(lottiePadding)
        }
        return this
    }//tested


    //style-----------------------------------------------------------------------------------------
    /**
     * @param titleStyle 0 -> normal , 1 -> bold , 2 -> italic
     */
    fun setTextStyle(titleStyle : Int = 0 , descriptionStyle : Int = 0 , buttonStyle : Int = 0) : CustomEmptyState{
        with(binding){
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
        }
        return this
    }//tested


    //background --------------------------------------------------------------------------------
    fun setButtonBackgroundColor(@ColorRes background : Int) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setButtonBackgroundDrawable(@DrawableRes background : Int) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setTitleBackgroundColor(@ColorRes background : Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setTitleBackgroundDrawable(@DrawableRes background : Int) : CustomEmptyState{
        with(binding){
            txtEmptyStateTitle.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setDescriptionBackgroundColor(@ColorRes background : Int) : CustomEmptyState {
        with(binding){
            txtEmptyStateDesc.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setDescriptionBackgroundDrawable(@DrawableRes background : Int) : CustomEmptyState {
        with(binding){
            txtEmptyStateDesc.setBackgroundResource(background)
        }
        return this
    }//tested

    fun setMainBackgroundColor(@ColorRes background : Int) : CustomEmptyState {
        with(binding) {
            mainEmptyState.setBackgroundResource(background)
        }//tested
        return this
    }

    fun setMainBackgroundDrawable(@DrawableRes background : Int) : CustomEmptyState {
        with(binding) {
            mainEmptyState.setBackgroundResource(background)
        }//tested
        return this
    }


    //click listener--------------------------------------------------------------------------------
    fun setOnOkClickListener(onClick:(View) -> Unit) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.setOnClickListener {
                onClick(it)
            }
        }
        return this
    }//tested


    //lottie----------------------------------------------------------------------------------------
    fun setupLottieAnimation(@RawRes rawRes : Int, loop : Boolean = true, padding : Int = 0) : CustomEmptyState{
        with(binding){
            imgEmptyState.visibility = View.INVISIBLE
            lottieAnimation.visibility = View.VISIBLE
            lottieAnimation.setAnimation(rawRes)
            lottieAnimation.playAnimation().hashCode()
            lottieAnimation.loop(loop)
            lottieAnimation.setPadding(padding)
        }
        return this
    }//tested


    //button----------------------------------------------------------------------------------------
    fun setButtonAttribute(radius: Int = 12 , icon: Int , iconSize : Int = 30 , @ColorRes color : Int = R.color.white) : CustomEmptyState{
        with(binding){
            btnEmptyStateSuccess.cornerRadius = radius
            btnEmptyStateSuccess.icon = ContextCompat.getDrawable(context , icon)
            btnEmptyStateSuccess.iconSize = iconSize
            btnEmptyStateSuccess.setIconTintResource(color)
        }
        return this
    }//not work

}