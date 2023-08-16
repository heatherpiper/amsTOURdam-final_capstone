<template>
    <main>
        <OriginDestinationForm />
        <RouteList />
        <DirectionsMapView />


    </main>
</template>

<script>
import OriginDestinationForm from '@/components/TrialMap/OriginDestinationForm.vue';
import RouteList from '@/components/TrialMap/RouteList.vue';
import DirectionsMapView from '@/components/TrialMap/DirectionsMapView.vue';



export default {
    components: {
        OriginDestinationForm,
        RouteList,
        DirectionsMapView,
    }

}
</script>
