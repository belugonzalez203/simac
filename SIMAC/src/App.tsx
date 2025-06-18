import { Routes, Route } from 'react-router-dom';
import MainLayout from "./layout/MainLayout.tsx";
//import Sidebar from './components/Sidebar';
import TechnicianView from "./views/TechnicianView/TechnicianView.tsx";
import EquipmentView from "./views/EquipmentView/EquipmentView.tsx";
import AreaView from "./views/AreaView/AreaView.tsx";
import SparePartsView from "./views/SparePartsView/SpareParts.tsx";
import CreateEquipmentView from "./views/EquipmentView/CreateEquipmentView.tsx";
import CreateSparePartsView from "./views/SparePartsView/CreateSparePartsView.tsx";
import CreateAreaView from "./views/AreaView/CreateAreaView.tsx";
import CreateTechnicianView from "./views/TechnicianView/CreateTechnicianView.tsx";
import ViewOrderReceived from "./views/OrderView/ViewOrderReceived.tsx";
import OrderReceivedList from "./views/OrderView/ListOrderReceived.tsx"


const App = () => {
    return (
        <MainLayout>
            <Routes>
                <Route path="/tecnicos" element={<TechnicianView />} />
                <Route path="/equipos" element={<EquipmentView />} />
                <Route path="/areas" element={<AreaView />} />
                <Route path="/repuestos" element={<SparePartsView />} />
                <Route path="*" element={<TechnicianView />} />
                <Route path="/equipment/create" element={<CreateEquipmentView />} />
                <Route path="/area/create" element={<CreateAreaView />} />
                <Route path="/spareParts/create" element={<CreateSparePartsView />} />
                <Route path="/technician/create" element={<CreateTechnicianView />} />
                <Route path="/order/received" element={<ViewOrderReceived />} />
                <Route path="/order/receivedList" element={<OrderReceivedList />} />
            </Routes>
        </MainLayout>
    );

}

export default App;
