package di

import feautres.listing_presentation.ListingViewModel
import feautres.quote.presentation.viewmodel.QuoteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


actual val viewModelModule = module {


    singleOf(::QuoteViewModel)
    singleOf(::ListingViewModel)


}