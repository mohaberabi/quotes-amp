package di

import feautres.listing_presentation.ListingViewModel
import feautres.quote.presentation.viewmodel.QuoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


actual val viewModelModule = module {
    viewModelOf(::QuoteViewModel)
    viewModelOf(::ListingViewModel)
}





