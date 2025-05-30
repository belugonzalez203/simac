import { Routes, Route } from 'react-router-dom';
import MainLayout from "./layout/MainLayout.tsx";
//import Sidebar from './components/Sidebar';
import TechnicianView from "./views/TechnicianView.tsx";
import EquipmentView from "./views/EquipmentView.tsx";
import AreaView from "./views/AreaView.tsx";
import SparePartsView from "./views/SpareParts.tsx";



const App = () => {
    return (
        <MainLayout>
            <Routes>
                <Route path="/tecnicos" element={<TechnicianView />} />
                <Route path="/equipos" element={<EquipmentView />} />
                <Route path="/areas" element={<AreaView />} />
                <Route path="/repuestos" element={<SparePartsView />} />
                {/*<Route path="/ordenes" element={<OrdenesView />} />
                <Route path="/horometros" element={<HorometrosView />} />
                <Route path="/recursos" element={<RecursosView />} />
                {/* Ruta por defecto */}
                <Route path="*" element={<TechnicianView />} />
            </Routes>
        </MainLayout>
    );

}

export default App;

/**
 *
 *  return (
 *         <MainLayout>
 *             <TechnicianView />
 *         </MainLayout>
 *     );
 */